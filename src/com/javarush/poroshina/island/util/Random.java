package com.javarush.poroshina.island.util;

import com.javarush.poroshina.island.repository.Factory;

import java.util.concurrent.ThreadLocalRandom;

public final class Random {

    public final static double startFactor = 0.75;
    public final static double multiplyFactor = 0.1;
    public final static int minChance = 0;
    public final static int maxChance = 101;


    //все операции рандомизации сюда скинуть
    //многопоточный рандом
    //все методы должны быть здесь public static


    public static int getRandomInt(double value) {
        return ThreadLocalRandom.current().nextInt((int) value);
    }

    public static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from ,to);
    }

    public static boolean getRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public static int getMaxInt(int[] numbers) {
        int max = numbers[0];

        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }
}
