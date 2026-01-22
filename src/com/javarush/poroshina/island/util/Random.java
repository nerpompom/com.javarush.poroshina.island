package com.javarush.poroshina.island.util;

import java.util.concurrent.ThreadLocalRandom;

public final class Random {

    public final static double startFactor = 0.75;
    public final static double multiplyPlantFactor = 0.007;
    public final static int minChance = 0;
    public final static int maxChance = 101;

    public static int getRandomInt(double value) {
        return ThreadLocalRandom.current().nextInt((int) value);
    }

    public static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from ,to);
    }

    public static boolean getRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
