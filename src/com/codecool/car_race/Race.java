package com.codecool.car_race;

import com.codecool.car_race.vehicle.Truck;
import com.codecool.car_race.vehicle.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class Race {
    private final List<Vehicle> vehicles = new LinkedList<>();
    private Weather weather = new Weather();
    static final int NUM_OF_LAPS = 50;
    public void registerRacer(Vehicle racer) {
        vehicles.add(racer);
    }

    private boolean brokenTruck;
    /**
     * Simulates the passing of time by advancing the weather and
     * moving the vehicles for the duration of a whole race.
     */


    public boolean isYellowFlagActive() {
        return brokenTruck;
    }

    public void simulateRace() {
        for (int i = 0; i < NUM_OF_LAPS; i++) {
            for (Vehicle vehicle : vehicles) {
                vehicle.prepareForlap(this);
                vehicle.moveForAnHour();
            }
            weather.randomize();
            brokenTruck = getBrokenTruckStatus();
        }
    }

    private boolean getBrokenTruckStatus() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                if (truck.isBrokenDown()) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Prints the state of all vehicles. Called at the end of the
     * race.
     */
    public void printRaceResults() {
        System.out.println("Race results:");
        vehicles.forEach(System.out::println);
    }
    public boolean isRaining() {
        return weather.isRaining();
    }

}
