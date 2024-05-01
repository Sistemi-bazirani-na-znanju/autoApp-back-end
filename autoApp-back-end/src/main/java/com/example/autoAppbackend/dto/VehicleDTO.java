package com.example.autoAppbackend.dto;

import com.example.autoAppbackend.model.Vehicle;
import com.example.autoAppbackend.model.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    
    private String modelName;
    private VehicleType currentState;
    private double price;
    private String imageURL;

    public VehicleDTO(Vehicle vehicle) {
        this.modelName = vehicle.getModelName();
        this.currentState =vehicle.getCurrentState();
        this.price = vehicle.getPrice();
        this.imageURL = vehicle.getImageURL();
    }
}
