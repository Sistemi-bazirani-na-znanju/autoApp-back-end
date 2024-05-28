package com.example.autoAppbackend.controller;

import com.example.autoAppbackend.dto.VehicleReservationDTO;
import com.example.autoAppbackend.model.VehicleReservation;
import com.example.autoAppbackend.service.VehicleReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vehicle-reservation")
public class VehicleReservationController {

    @Autowired
    VehicleReservationService vehicleReservationService;

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleReservationDTO>> getByUserId(@PathVariable Long id){
        List<VehicleReservation> reservations = vehicleReservationService.getAllByUserId(id);

        List<VehicleReservationDTO> reservationDTOs = new ArrayList<>();
        for(VehicleReservation r : reservations){
            reservationDTOs.add(new VehicleReservationDTO(r));
        }

        return new ResponseEntity<>(reservationDTOs, HttpStatus.OK);

    }

    @PutMapping(value = "/cancel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleReservationDTO> cancelReservation(@PathVariable Integer id,@RequestBody String reason){
        VehicleReservation reservation = vehicleReservationService.cancelReservation(id, reason);
        VehicleReservationDTO reservationDTO = new VehicleReservationDTO(reservation);
        return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/return/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleReservationDTO> returnVehicle(@PathVariable Integer id, @RequestBody String state){
        VehicleReservation reservation = vehicleReservationService.returnVehicle(id, state);
        VehicleReservationDTO reservationDTO = new VehicleReservationDTO(reservation);
        return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/pickup/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleReservationDTO> pickupVehicle(@PathVariable Integer id){
        VehicleReservation reservation = vehicleReservationService.pickupVehicle(id);
        return new ResponseEntity<>(new VehicleReservationDTO(reservation), HttpStatus.OK);
    }

    @GetMapping(value = "/scheduled", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleReservationDTO>> getAllScheduledReservations(){
        List<VehicleReservation> reservations = vehicleReservationService.getAllScheduledReservations();

        List<VehicleReservationDTO> reservationDTOs = new ArrayList<>();
        for(VehicleReservation r : reservations){
            reservationDTOs.add(new VehicleReservationDTO(r));
        }

        return new ResponseEntity<>(reservationDTOs, HttpStatus.OK);
    }
}
