package com.example.autoAppbackend.service;

import com.example.autoAppbackend.model.VehicleReservation;
import com.example.autoAppbackend.repository.VehicleReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleReservationService {

    @Autowired
    VehicleReservationRepository vehicleReservationRepository;


    public List<VehicleReservation> getAllByUserId(Long id){
        return vehicleReservationRepository.findVehicleReservationsByUserId(id);
    }


}
