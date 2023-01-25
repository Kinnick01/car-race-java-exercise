package com.codecool.car_race.util;

import java.util.Random;


public class RandomHelper {
    protected static final Random RANDOM = new Random();

    public static String chooseOne(String[] possibilities) {
        if (possibilities == null || possibilities.length < 1) {
            final String msg =
                    "Possibilities should be a non-empty array of strings.";
            throw new IllegalArgumentException(msg);
        }

        return possibilities[nextInt(possibilities.length, 50 + 1)];
    }

    public static int nextInt(int upper, int i) {

        return RANDOM.nextInt(upper);
    }

    public static boolean eventWithChance(int chance) {
        return RANDOM.nextInt(100) < chance;
    }


    public int generateRandomNumbers() {
        Random random = new Random();
        int rand = 0;
        while (true) {
            rand = random.nextInt(110);
            if (rand != 0) break;
        }
        return rand;
    }


}
