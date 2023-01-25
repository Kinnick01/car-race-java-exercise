package com.codecool.car_race.vehicle;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

import javax.swing.plaf.nimbus.State;

public class Truck extends Vehicle {
    //private static final int NORMAL_SPEED = ;
    RandomHelper num = new RandomHelper();
    private static final int BREAKDOWN_CHANCE = 5;
    private static final int TURNS_NEEDED_TO_FIX_TRUCK = 2;
    private int breakdownTurnsLeft;

    private State nextState() {
        switch (state) {
            case OPERATIONAL:
                if (RandomHelper.eventWithChance(BREAKDOWN_CHANCE)) {
                    breakdownTurnsLeft = TURNS_NEEDED_TO_FIX_TRUCK;
                    return State.BROKEN_DOWN;
                }
                break;
            case BROKEN_DOWN:
                if (breakdownTurnsLeft-- > 0) {
                    return State.BROKEN_DOWN;
                }
                break;
        }
        return State.OPERATIONAL;
    }

    private State state = State.OPERATIONAL;

    private enum State {
        OPERATIONAL,
        BROKEN_DOWN
    }

    public boolean isBrokenDown() {
        return state != State.OPERATIONAL;
    }

    protected String generateName() {
        return Integer.toString(num.generateRandomNumbers());
    }

    public Truck(String name, int normalSpeed) {
        this.name = generateName();
        this.normalSpeed = 100;
    }

    @Override
    public void prepareForlap(Race race) {
        if (isBrokenDown()) actualSpeed = 0;
        else actualSpeed = normalSpeed;


        state = nextState();
    }
}
