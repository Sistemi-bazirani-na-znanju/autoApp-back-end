package com.example.autoAppbackend.service;

import com.example.autoAppbackend.model.ReservationStatus;
import com.example.autoAppbackend.model.VehicleReservation;
import com.example.autoAppbackend.model.VehicleType;
import com.example.autoAppbackend.repository.VehicleReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class VehicleReservationService {

    @Autowired
    VehicleReservationRepository vehicleReservationRepository;


    public List<VehicleReservation> getAllByUserId(Long id){
        return vehicleReservationRepository.findVehicleReservationsByUserId(id);
    }

    @Transactional
    public VehicleReservation cancelReservation(Integer id, String reason){
        VehicleReservation reservation = vehicleReservationRepository.getById(id);
        reservation.setCancellationTime(LocalDateTime.now());
        reservation.setCancellationReason(reason);
        reservation.setStatus(ReservationStatus.CANCELLED);
        return vehicleReservationRepository.save(reservation);
    }

    @Transactional
    public VehicleReservation returnVehicle(Integer id, String state){
        VehicleReservation reservation = vehicleReservationRepository.getById(id);

        switch(state){
            case "FULLY_FUNCTIONAL":
                reservation.setVehicleState(VehicleType.FULLY_FUNCTIONAL);
                break;
            case "DAMAGED":
                reservation.setVehicleState(VehicleType.DAMAGED);
                break;
            case "DIRTY":
                reservation.setVehicleState(VehicleType.DIRTY);
                break;
            default:
                reservation.setVehicleState(VehicleType.OTHER);
                break;
        }

        reservation.setActualReturnTime(LocalDateTime.now());
        reservation.setStatus(ReservationStatus.RETURNED);
        return vehicleReservationRepository.save(reservation);
    }

    @Transactional
    public VehicleReservation pickupVehicle(Integer id){
        VehicleReservation reservation = vehicleReservationRepository.getById(id);
        reservation.setStatus(ReservationStatus.TAKEN);
        return vehicleReservationRepository.save(reservation);
    }

    public List<VehicleReservation> getAllScheduledReservations(){
        List<VehicleReservation> reservations = vehicleReservationRepository.findVehicleReservationsByStatus(ReservationStatus.SCHEDULED);
        return reservations;
    }


}
