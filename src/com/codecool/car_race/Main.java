package com.codecool.car_race;


import com.codecool.car_race.util.RandomHelper;
import com.codecool.car_race.vehicle.Car;
import com.codecool.car_race.vehicle.Motorcycle;
import com.codecool.car_race.vehicle.Truck;

import java.util.Random;

public class Main {

    /**
     * Creates all the vehicles that will be part of this race.
     */
    private static void createVehicles(Race race) {
        RandomHelper num = new RandomHelper();

        for (int i = 0; i < 10; i++) {
            race.registerRacer(new Car("car",num.generateRandomNumbers()));
            race.registerRacer(new Motorcycle("moto",num.generateRandomNumbers()));
            race.registerRacer(new Truck("truck",num.generateRandomNumbers()));
        }
    }


    /**
     * Entry point of our program. Creates one race instance and
     * uses that.
     * <p>
     *
     * @param args commandline arguments passed to the program.
     *             It is unused.
     */
    public static void main(String[] args) {
        Race race = new Race();
        createVehicles(race);

        race.simulateRace();
        race.printRaceResults();
    }
}
