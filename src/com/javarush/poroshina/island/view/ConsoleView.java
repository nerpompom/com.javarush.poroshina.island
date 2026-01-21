package com.javarush.poroshina.island.view;

import com.javarush.poroshina.island.entity.population.Population;

public class ConsoleView {

    public static String getPicture(Population name) {
            switch (name) {
                case BOAR -> {
                    return "\uD83D\uDC17";
                }
                case BUFFALO -> {
                    return "\uD83D\uDC03";
                }
                case CATERPILLAR -> {
                    return "\uD83D\uDC1B";
                }
                case DEER -> {
                    return "\uD83E\uDD8C";
                }
                case DUCK -> {
                    return "\uD83E\uDD86";
                }
                case GOAT -> {
                    return "\uD83D\uDC10";
                }
                case HORSE -> {
                    return "\uD83D\uDC0E";
                }
                case MOUSE -> {
                    return "\uD83D\uDC01";
                }
                case RABBIT -> {
                    return "\uD83D\uDC07";
                }
                case SHEEP -> {
                    return "\uD83D\uDC11";
                }
                case BEAR -> {
                    return "\uD83D\uDC3B";
                }
                case BOA -> {
                    return "\uD83D\uDC0D";
                }
                case EAGLE -> {
                    return "\uD83E\uDD85";
                }
                case FOX -> {
                    return "\uD83E\uDD8A";
                }
                case WOLF -> {
                    return "\uD83D\uDC3A";
                }
                case PLANT -> {
                    return "\uD83C\uDF34";
                }
                default -> {
                    return "unknown";
                }
            }
    }
}
