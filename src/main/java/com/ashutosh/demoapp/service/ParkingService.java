package com.ashutosh.demoapp.service;

import com.ashutosh.demoapp.model.Car;
import com.ashutosh.demoapp.model.ParkingLot;
import com.ashutosh.demoapp.model.Slot;
import com.ashutosh.demoapp.model.Status;
import com.ashutosh.demoapp.repo.CarRepository;
import com.ashutosh.demoapp.repo.ParkingLotRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParkingService {
    private CarService carService;
    private ParkingLot parkingLot;
    private ParkingLotRepository parkingLotRepository;
    private CarRepository carRepository;
    private Map<Integer, Slot> slotMap = new HashMap<>();
    private List<Car> carList = carService.getAllCars();
    public ParkingLot createParkingLot() {
        ParkingLot parkingLot = new ParkingLot();
        return parkingLot;
    }
    public String parkVehicle(String registrationNumber, String color) {
        //validateCar(String registrationNumber); to validate if the registration number is unique of not
        Car car = new Car(registrationNumber,color);
        carList.add(car);
        List<Slot> slots = parkingLot.getSlots();
        for(Slot slot : slots){
            if(Objects.nonNull(slot)) {
                if(slot.getStatus().equals(Status.AVAILABLE.toString())) {
                    slot.setCar(car);
                    slotMap.put(slot.getSlotNumber(),slot);
                }
                return "Allocated slot number "+slot.getSlotNumber();
            }
        }
        return "No parking spots available";
    }

    public String leaveParkingLot(int slotNumber) {
        List<Slot> slots = parkingLot.getSlots();
        for(Slot slot: slots) {
            if(Objects.nonNull(slot)) {
                if(slot.getSlotNumber() == slotNumber && slot.getStatus().equals(Status.OCCUPIED)){
                    slot.setStatus(Status.AVAILABLE);
                    slot.setCar(null);
                    slotMap.remove(slotNumber);
                    return "Slot number"+slotNumber+" is free";
                }
            }
        }
        return "No car in the selected slot";
    }

    public String findCarByColor(String color) {
        List<String> registrationNumberList = new ArrayList<>();
        List<Car> carList = carService.getAllCars();
        for(Car car : carList) {
            if(Objects.nonNull(car)){
                if(car.getColor().equals(color)){
                    registrationNumberList.add(car.getVehicleNumber());
                }
            }
        }
        return "Registration numbers of cars with color: "+color+registrationNumberList;
    }
}
