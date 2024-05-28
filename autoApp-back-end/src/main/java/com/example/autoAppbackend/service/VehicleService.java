package com.example.autoAppbackend.service;

import com.example.autoAppbackend.model.Vehicle;
import com.example.autoAppbackend.model.VehicleReservation;
import com.example.autoAppbackend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Optional<Vehicle> getById(int id) {
        return vehicleRepository.findById(id);
    }

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle create(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
