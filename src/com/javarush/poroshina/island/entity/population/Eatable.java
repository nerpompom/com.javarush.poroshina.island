package com.javarush.poroshina.island.entity.population;

import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.animal.Animal;

import java.util.List;

public interface Eatable {

    Population getPopulation();

    boolean isBeEaten();

    Eatable die();

    static void populationDie(List<Eatable> eatables) {

        eatables.replaceAll(eatable -> {
            if (eatable.isBeEaten()) {
                return eatable.die();
            } else if (eatable instanceof Animal animal && animal.isHungry()) {
                return eatable.die();
            }
            return eatable;
        });
    }

}
