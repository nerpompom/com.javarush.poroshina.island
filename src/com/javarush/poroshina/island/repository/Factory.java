package com.javarush.poroshina.island.repository;

import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.Population;

public abstract class Factory {

    public abstract Eatable create(Population population, Location location);

}
