package com.javarush.poroshina.island.entity.population;

import com.javarush.poroshina.island.entity.island.Location;

public interface Eatable {

    Population getPopulation();

    boolean isBeEaten();

    Eatable die();

    static void populationDie(Location location) {
        for (int i = 0; i < location.getLocationPopulation().size(); i++) {
            Eatable eatable = location.getLocationPopulation().get(i);

            if (eatable.isBeEaten()) {
                location.getLocationPopulation().set(i, eatable.die());
            }
        }
    };

}
