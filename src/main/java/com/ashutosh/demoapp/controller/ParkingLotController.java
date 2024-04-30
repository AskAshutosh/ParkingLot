package com.ashutosh.demoapp.controller;

import com.ashutosh.demoapp.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingLotController {
    @Autowired
    ParkingService parkingService;
    public String parkVehicle(String registrationNumber, String color) {
        return parkingService.parkVehicle(registrationNumber, color);
    }

    public String leaveParkingSpot(int slotNumber) {
        return parkingService.leaveParkingLot(slotNumber);
    }

}
