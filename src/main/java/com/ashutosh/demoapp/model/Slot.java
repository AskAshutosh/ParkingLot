package com.ashutosh.demoapp.model;

import lombok.Data;

import java.util.List;

@Data
public class Slot {
    private Car car;
    private Status status;
    private int slotNumber;

    public Slot getSlot(){
        return this;
    }
}
