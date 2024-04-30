package com.ashutosh.demoapp.model;

import lombok.Data;

import java.util.List;

@Data
public class ParkingLot {
    List<Slot> slots;
}
