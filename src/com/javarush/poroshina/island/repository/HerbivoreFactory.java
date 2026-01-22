package com.javarush.poroshina.island.repository;

import com.javarush.poroshina.island.config.AppConstants;
import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.entity.population.animal.herbivore.*;

public class HerbivoreFactory extends Factory {

    @Override
    public Eatable create(Population population, Location location) {
        switch (population) {
            case BOAR -> {
                return new Boar(location, PopulationSettings.boarWeight, PopulationSettings.boarFull, PopulationSettings.boarSpeed);
            }
            case BUFFALO -> {
                return new Buffalo(location, PopulationSettings.buffaloWeight, PopulationSettings.buffaloFull, PopulationSettings.buffaloSpeed);
            }
            case CATERPILLAR -> {
                return new Caterpillar(location, PopulationSettings.caterpillarWeight, PopulationSettings.caterpillarFull, PopulationSettings.caterpillarSpeed);
            }
            case DEER -> {
                return new Deer(location, PopulationSettings.deerWeight, PopulationSettings.deerFull, PopulationSettings.deerSpeed);
            }
            case DUCK -> {
                return new Duck(location, PopulationSettings.duckWeight, PopulationSettings.duckFull, PopulationSettings.duckSpeed);
            }
            case GOAT -> {
                return new Goat(location, PopulationSettings.goatWeight, PopulationSettings.goatFull, PopulationSettings.goatSpeed);
            }
            case HORSE -> {
                return new Horse(location, PopulationSettings.horseWeight, PopulationSettings.horseFull, PopulationSettings.horseSpeed);
            }
            case MOUSE -> {
                return new Mouse(location, PopulationSettings.mouseWeight, PopulationSettings.mouseFull, PopulationSettings.mouseSpeed);
            }
            case RABBIT -> {
                return new Rabbit(location, PopulationSettings.rabbitWeight, PopulationSettings.rabbitFull, PopulationSettings.rabbitSpeed);
            }
            case SHEEP -> {
                return new Sheep(location, PopulationSettings.sheepWeight, PopulationSettings.sheepFull, PopulationSettings.sheepSpeed);
            }
            default -> {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + ": " + AppConstants.EATABLE_CREATE_ERROR);
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
