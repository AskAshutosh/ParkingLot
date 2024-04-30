package com.ashutosh.demoapp;

import com.ashutosh.demoapp.controller.ParkingLotController;

import java.util.Scanner;

public class ParkingLotMain {
    private static final ParkingLotController parkingLotController = new ParkingLotController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("park with Enter car number and color");
        String input = scanner.nextLine();
        String registationNumber = scanner.next();
        String color = scanner.next();
        StringBuilder command = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
            int ch = input.charAt(i);
            if(((ch >= 97) &&  (ch<= 122)) || ((ch>=65 ) && (ch<=90))) {
                command.append(input.charAt(i));
            } else {
                break;
            }
        }
        switch (command.toString()) {
            case "park":
                parkingLotController.parkVehicle(registationNumber, color);
                break;
            case "leave":
                parkingLotController.leaveParkingSpot(Integer.parseInt(registationNumber));
                break;
        }
    }
}
