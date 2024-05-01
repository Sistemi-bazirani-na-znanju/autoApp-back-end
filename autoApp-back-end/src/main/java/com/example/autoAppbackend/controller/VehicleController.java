package com.example.autoAppbackend.controller;

import com.example.autoAppbackend.dto.VehicleDTO;
import com.example.autoAppbackend.model.Vehicle;
import com.example.autoAppbackend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> getById(@PathVariable int id) {
        Optional<Vehicle> vehicle = vehicleService.getById(id);
        if (vehicle.isPresent()) {
            return new ResponseEntity<>(new VehicleDTO(vehicle.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleDTO>> getAll() {
        List<Vehicle> vehicles = vehicleService.getAll();
      
        List<VehicleDTO> VehicleDto = new ArrayList<>();
        for(Vehicle r : vehicles){
            VehicleDto.add(new VehicleDTO(r));
        }

        return new ResponseEntity<>(VehicleDto, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> create(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle(vehicleDTO.getModelName(), vehicleDTO.getCurrentState(), vehicleDTO.getPrice(), vehicleDTO.getImageURL());
        vehicle = vehicleService.create(vehicle);
        return new ResponseEntity<>(new VehicleDTO(vehicle), HttpStatus.CREATED);
    }
}
