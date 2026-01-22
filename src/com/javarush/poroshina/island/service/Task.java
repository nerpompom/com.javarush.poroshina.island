package com.javarush.poroshina.island.service;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.animal.Animal;
import com.javarush.poroshina.island.entity.population.plant.Plant;
import java.util.List;

public class Task implements Runnable {

    private final Eatable eatable;
    private final Location location;
    private final List<Eatable> eatables;

    public Task(Eatable eatable, Location location, List<Eatable> eatables) {
        this.eatable = eatable;
        this.location = location;
        this.eatables = eatables;
    }

    @Override
    public void run() {
        if (eatable instanceof Animal animal && eatable != null) {
            if (animal.getCurrentFull() < animal.getFull()) {
                animal.eat(location, eatables);
            } else {
                animal.setCurrentFull(0);
            }

            boolean hasSameAnimal = eatables.stream()
                    .anyMatch(eatable -> eatable.getClass().equals(this.getClass()));

            if (hasSameAnimal) {
                animal.multiply(location, eatables);
            }

            Eatable.populationDie(eatables);

            long plantCount = eatables.stream()
                    .filter(eatable -> eatable instanceof Plant)
                    .count();

            if (plantCount < PopulationSettings.maxPlantCount) {
                Plant.grow(location, eatables);
            }

            eatables.removeIf(eatable -> eatable == null);
            animal.move(location);
        }
    }
}
