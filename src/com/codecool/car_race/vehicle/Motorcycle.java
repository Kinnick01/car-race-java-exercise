package com.codecool.car_race.vehicle;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

public class Motorcycle extends Vehicle {
    private static int motorcycleNumber = 1;
    RandomHelper randnum = new RandomHelper();

    @Override
    protected String generateName() {
        return "Motorcycle" + motorcycleNumber++;
    }

    public Motorcycle(String name, int normalSpeed) {
        this.name = "M.cycle";
        this.normalSpeed = 100;
    }

    @Override
    public void prepareForlap(Race race) {
        actualSpeed = normalSpeed;

        if (race.isRaining()) {
            int slowDown = randnum.generateRandomNumbers();
            actualSpeed -= slowDown;
        }

    }
}
