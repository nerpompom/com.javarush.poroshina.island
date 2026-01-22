package com.javarush.poroshina.island.entity.population.animal.predator;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.entity.population.animal.Animal;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.util.Random;
import com.javarush.poroshina.island.util.Statistics;

import java.util.List;
import java.util.stream.IntStream;

public abstract class Predator extends Animal {

    public Predator(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }


//    @Override
//    public void eat(Eatable food) {
//        System.out.println("Здесь реализую прием пищи хищника");
//
//    }

    @Override
    public void move(Location location) {

    }

    @Override
    public void multiply(Location location, List<Eatable> eatables) {
        location.getLock().lock();

        Eatable newborn = location.getPredatorfactory().create(this.getPopulation(), location);
        eatables.add(newborn);
        this.setReadyToMultiply(false);

        location.getLock().unlock();
    }

}
