package com.example.autoAppbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.autoAppbackend.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    
}
