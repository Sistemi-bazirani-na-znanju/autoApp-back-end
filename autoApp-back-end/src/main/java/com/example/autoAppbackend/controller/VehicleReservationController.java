package com.example.autoAppbackend.controller;

import com.example.autoAppbackend.dto.VehicleReservationDTO;
import com.example.autoAppbackend.model.VehicleReservation;
import com.example.autoAppbackend.service.VehicleReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
