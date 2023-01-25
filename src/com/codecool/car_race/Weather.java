package com.codecool.car_race;

import com.codecool.car_race.util.RandomHelper;

public class Weather {
    private static final int CHANCE_OF_RAIN = 30;

    /**
     * State of rain.
     */
    private boolean isRaining = false;

    /**
     * Randomize the state of the rain in the constructor
     */
    public void Weather() {
        randomize();
    }

    /**
     * Whether it is raining in the current time-step.
     *
     * @return true if it is raining.
     */
    public boolean isRaining() {
        return isRaining;
    }

    /**
     * Calculate the new state of the weather.
     */
    public void randomize() {
        isRaining = RandomHelper.eventWithChance(CHANCE_OF_RAIN);
    }
}

