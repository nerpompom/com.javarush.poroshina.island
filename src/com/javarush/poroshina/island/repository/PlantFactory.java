package com.javarush.poroshina.island.repository;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.plant.Plant;
import com.javarush.poroshina.island.entity.population.Population;

public class PlantFactory extends Factory {

    @Override
    public Eatable create(Population population, Location location) {
        return new Plant(location, PopulationSettings.plantWeight);
    }
}
