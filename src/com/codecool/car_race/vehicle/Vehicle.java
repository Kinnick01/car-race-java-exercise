package com.codecool.car_race.vehicle;

import com.codecool.car_race.Race;

abstract public class Vehicle {
    protected String name;
    protected int normalSpeed;
    protected int actualSpeed;
    protected int distanceTravelled;
    protected abstract String generateName();
    public Vehicle(String name, int normalSpeed) {
        this.name = genereateName();
        this.normalSpeed = 100;
    }

    private String genereateName(){return name;}



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{")
                .append("distance travelled: ")
                .append(distanceTravelled)
                .append(", ")
                .append("type: ")
                .append(getClass().getSimpleName())
                .append(", ")
                .append("name: ")
                .append(name)
                .append("}");
        return sb.toString();
    }

    protected Vehicle() {
    }

    public abstract void prepareForlap(Race race);

    public final void moveForAnHour() {
        distanceTravelled += actualSpeed;
    }
}
