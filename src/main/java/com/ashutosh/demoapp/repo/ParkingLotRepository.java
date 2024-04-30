package com.ashutosh.demoapp.repo;

import com.ashutosh.demoapp.model.Slot;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ParkingLotRepository {
    Map<Integer, Slot> slotMap = new HashMap<>();
}
