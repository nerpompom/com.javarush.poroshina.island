package com.javarush.poroshina.island.repository;

import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.Population;

public abstract class Factory {
    //Скорее всего не общая для всех объектов, возможно будет иерархия
    //Будет формировать объекты и на старте и потом, когда животные например, размножатся

    public abstract Eatable create(Population population, Location location);

}
