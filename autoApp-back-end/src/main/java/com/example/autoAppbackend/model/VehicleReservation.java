package com.example.autoAppbackend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleReservation extends GenericEntity{

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Vehicle vehicle;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private User user;

    @Column
    private LocalDateTime reservationTime;

    @Column
    private LocalDateTime cancellationTime;  // -

    @Column
    private String cancellationReason; // -

    @Column
    @NotNull
    private LocalDateTime scheduledPickupTime;

    @Column
    @NotNull
    private LocalDateTime scheduledReturnTime;

    @Column
    private LocalDateTime actualReturnTime; // -

    @Column
    private VehicleType vehicleState; // -

    @Column
    private ReservationStatus status;

}
