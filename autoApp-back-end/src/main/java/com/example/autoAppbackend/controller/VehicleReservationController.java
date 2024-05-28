package com.example.autoAppbackend.controller;

import com.example.autoAppbackend.dto.UserDTO;
import com.example.autoAppbackend.dto.VehicleDTO;
import com.example.autoAppbackend.dto.VehicleReservationDTO;
import com.example.autoAppbackend.model.User;
import com.example.autoAppbackend.model.Vehicle;
import com.example.autoAppbackend.model.VehicleReservation;
import com.example.autoAppbackend.service.UserService;
import com.example.autoAppbackend.service.VehicleReservationService;
import com.example.autoAppbackend.service.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicle-reservation")
public class VehicleReservationController {

    @Autowired
    VehicleReservationService vehicleReservationService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleReservationDTO>> getByUserId(@PathVariable Long id){
        List<VehicleReservation> reservations = vehicleReservationService.getAllByUserId(id);

        List<VehicleReservationDTO> reservationDTOs = new ArrayList<>();
        for(VehicleReservation r : reservations){
            reservationDTOs.add(new VehicleReservationDTO(r));
        }

        return new ResponseEntity<>(reservationDTOs, HttpStatus.OK);

    }


    @Operation(summary = "Create new vehicle reservation", description = "Creates new vehicle reservation", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VehicleReservationDTO.class)) })
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleReservationDTO> saveArrangement(@RequestBody VehicleReservationDTO vehicleReservationDTO) {

        VehicleReservation vehicleReservation = new VehicleReservation();

        User user = userService.getById(vehicleReservationDTO.getUser().getId());
        if(user != null){
            vehicleReservation.setUser(user);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }   


        Optional<Vehicle> vehicle = vehicleService.getById(vehicleReservationDTO.getVehicle().getId().intValue());
        if (vehicle.isPresent()) {
            vehicleReservation.setVehicle(vehicle.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        

        vehicleReservation.setReservationTime(vehicleReservationDTO.getReservationTime());
        vehicleReservation.setScheduledPickupTime(vehicleReservationDTO.getScheduledPickupTime());
        vehicleReservation.setScheduledReturnTime(vehicleReservationDTO.getScheduledReturnTime());
        vehicleReservation.setStatus(vehicleReservationDTO.getStatus());

        vehicleReservation = vehicleReservationService.save(vehicleReservation);

        return new ResponseEntity<>(new VehicleReservationDTO(vehicleReservation), HttpStatus.CREATED);
    }

}
