package com.codecool.car_race.vehicle;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

public class Car extends Vehicle {
    protected static final int YELLOW_FLAG_SPEED = 75;
RandomHelper dandomnumbert = new RandomHelper();
    public Car(String name, int normalSpeed) {
        this.name = generateName();
        this.normalSpeed = dandomnumbert.generateRandomNumbers();
    }

    private static final String[] POSSIBLE_NAMES = {
            "Wind-Up Powerplane",
            "Bio-Powered Eternicopter",
            "Tesla Automobile",
            "The Frog",
            "The Oasis",
            "The Rattle",
            "Eoglixcar",
            "Boowetruck",
            "Gaekamtruck,",
            "Hydraulic Aquatruck",
            "Transmutation Hovercar",
            "Bio-Powered Antiquitruck",
            "Steam-Powered Pulsebus",
            "Flaadrucycle",
            "Ooblesled",
            "Gluroboard"};

    @Override
    protected String generateName() {
        String firstName = RandomHelper.chooseOne(POSSIBLE_NAMES);
        String lastName = RandomHelper.chooseOne(POSSIBLE_NAMES);
        return firstName + " " + lastName;
    }

    @Override
    public void prepareForlap(Race race) {
        if (race.isYellowFlagActive()) actualSpeed = YELLOW_FLAG_SPEED;
        else actualSpeed = normalSpeed;

    }
}
