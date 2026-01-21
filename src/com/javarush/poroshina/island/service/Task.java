package com.javarush.poroshina.island.service;

import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.animal.Animal;
import com.javarush.poroshina.island.entity.population.plant.Plant;

public class Task {

    private final Eatable eatable;
    private final Location location;

    public Task(Eatable eatable, Location location) {
        this.eatable = eatable;
        this.location = location;
    }

    public void doTack() {
//        может проверку на ноль куда-то выше запихнуть?
        if (eatable instanceof Animal animal && eatable != null) {
            animal.eat(location);
//            animal.multiply(location);
//            animal.move(location);
        }
        Eatable.populationDie(location);
//
//        if (eatable instanceof Plant plant && eatable != null) {
//            plant.grow(location);
//        }
    }
}
