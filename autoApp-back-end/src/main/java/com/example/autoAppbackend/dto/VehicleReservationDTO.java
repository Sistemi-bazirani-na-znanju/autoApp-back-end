package com.example.autoAppbackend.dto;

import com.example.autoAppbackend.model.ReservationStatus;
import com.example.autoAppbackend.model.VehicleReservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleReservationDTO {

    private Integer id;
    private VehicleDTO vehicle;
    private UserDTO user;
    private LocalDateTime reservationTime;
    private LocalDateTime scheduledPickupTime;
    private LocalDateTime scheduledReturnTime;
    private ReservationStatus status;

    public VehicleReservationDTO(VehicleReservation vehicleReservation){
        this.id = vehicleReservation.getId();
        this.vehicle = new VehicleDTO(vehicleReservation.getVehicle());
        this.user = new UserDTO(vehicleReservation.getUser());
        this.reservationTime = vehicleReservation.getReservationTime();
        this.scheduledPickupTime = vehicleReservation.getScheduledPickupTime();
        this.scheduledReturnTime = vehicleReservation.getScheduledReturnTime();
        this.status = vehicleReservation.getStatus();
    }
}
