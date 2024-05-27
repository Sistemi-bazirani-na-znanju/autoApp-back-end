package com.example.autoAppbackend.repository;

import com.example.autoAppbackend.model.VehicleReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleReservationRepository extends JpaRepository<VehicleReservation, Integer> {

    List<VehicleReservation> findVehicleReservationsByUserId(Long id);
}
