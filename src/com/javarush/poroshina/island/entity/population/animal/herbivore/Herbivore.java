package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.entity.population.animal.Animal;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.util.Random;
import com.javarush.poroshina.island.util.Statistics;

import java.util.List;

public abstract class Herbivore extends Animal {

    public Herbivore(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }

    //Как-то возможно добавить настройку чтобы получать шанс съедения в этом методе
//    @Override
//    public void eat(Eatable food) {
//        System.out.println("Здесь реализую прием пищи травоядного");
//    }

    @Override
    public void multiply(Location location) {
        location.getLock().lock();
        //размножаться должны только с учетом того что есть другие животные того же вида
        if (isFull()) {
            List<Eatable> locationPopulation = location.getLocationPopulation();
            if (location.currentNameCount(getPopulation()) < Statistics.eatableMaxNumber(getPopulation())) {
                int children = Random.getRandomInt(Statistics.eatableMaxNumber(getPopulation()) * Random.multiplyFactor);
                if ((children + location.currentNameCount(getPopulation()) >= Statistics.eatableMaxNumber(getPopulation()))) {
                    int difference = 0;
                    int left = Statistics.eatableMaxNumber(getPopulation());
                    int right = location.currentNameCount(getPopulation());
                    difference = left - right;
                    for (int i = 0; i < difference; i++) {
                        //population.add(location.getHerbivoreFactory().create(getPopulation(), location));
                        //надо позаботиться чтобы попадало в список острова
                        locationPopulation.add(location.getHerbivoreFactory().create(getPopulation(), location));
                    }
                } else {
                    for (int i = 0; i < children; i++) {
                        //population.add(location.getHerbivoreFactory().create(getPopulation(), location));
                        //надо позаботиться чтобы попадало в список острова
                        locationPopulation.add(location.getHerbivoreFactory().create(getPopulation(), location));
                    }
                }
            }
        }
        location.getLock().unlock();
    }

}
