package com.javarush.poroshina.island.entity.population;

import com.javarush.poroshina.island.entity.island.Location;

import java.util.List;

public interface Eatable {

    Population getPopulation();

    boolean isBeEaten();

    Eatable die();

    static void populationDie(List<Eatable> eatables) {

        eatables.replaceAll(eatable -> {
            if (eatable.isBeEaten()) {
                return eatable.die();
            }
            return eatable;
        });
    }

}
