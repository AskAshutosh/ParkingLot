package com.ashutosh.demoapp.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Car {
    private String vehicleNumber;
    private String color;
}
