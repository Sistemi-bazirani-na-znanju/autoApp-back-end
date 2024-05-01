package com.example.autoAppbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends GenericEntity{
    @Column
    @NotNull
    private String modelName;

    @Column
    @NotNull
    private VehicleType currentState;

    @Column
    @NotNull
    private double price;

    @Column
    @NotNull
    private String imageURL;

}
