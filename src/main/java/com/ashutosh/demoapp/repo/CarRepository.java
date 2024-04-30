package com.ashutosh.demoapp.repo;

import com.ashutosh.demoapp.model.Car;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class CarRepository {
    List<Car> carList;
}
