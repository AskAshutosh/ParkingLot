package com.ashutosh.demoapp.service;

import com.ashutosh.demoapp.model.Car;
import com.ashutosh.demoapp.repo.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;
    public List<Car> getAllCars() {
        return carRepository.getCarList();
    }
}
