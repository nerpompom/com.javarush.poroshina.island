package com.javarush.poroshina.island.entity.population.plant;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;
import java.util.List;
import java.util.stream.IntStream;

public class Plant implements Eatable {

    Location location;
    double weight;
    boolean beEaten;

    public Plant(Location location, double weight) {
        this.location = location;
        this.weight = weight;
        this.beEaten = false;
    }

    @Override
    public boolean isBeEaten() {
        return beEaten;
    }

    public double getWeight() {
        return weight;
    }

    public void setBeEaten(boolean beEaten) {
        this.beEaten = beEaten;
    }

    @Override
    public Population getPopulation() {
        return Population.PLANT;
    }

    @Override
    public Eatable die() {
        return null;
    }

    public static void grow(Location location, List<Eatable> eatables) {
        location.getLock().lock();

        int count = (int) (PopulationSettings.maxPlantCount * Random.multiplyPlantFactor);
        IntStream.range(0, count)
                .mapToObj(i -> location.getPlantFactory().create(Population.PLANT, location))
                .forEach(eatables::add);

        location.getLock().unlock();
    }
}
