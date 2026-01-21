package com.javarush.poroshina.island.repository;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.entity.population.animal.predator.*;

public class PredatorFactory extends Factory {


    @Override
    public Eatable create(Population population, Location location) {
            switch (population) {
                case BEAR -> {
                    return new Bear(location, PopulationSettings.bearWeight, PopulationSettings.bearFull, PopulationSettings.bearSpeed);
                }
                case BOA -> {
                    return new Boa(location, PopulationSettings.boaWeight, PopulationSettings.boaFull, PopulationSettings.boaSpeed);
                }
                case EAGLE -> {
                    return new Eagle(location, PopulationSettings.eagleWeight, PopulationSettings.eagleFull, PopulationSettings.eagleSpeed);
                }
                case FOX -> {
                    return new Fox(location, PopulationSettings.foxWeight, PopulationSettings.foxFull, PopulationSettings.foxSpeed);
                }
                case WOLF -> {
                    return new Wolf(location, PopulationSettings.wolfWeight, PopulationSettings.wolfFull, PopulationSettings.wolfSpeed);
                }
                default -> {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    }
}
