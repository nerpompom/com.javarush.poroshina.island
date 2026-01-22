package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Deer extends Herbivore {
    public Deer(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxDeerCount;
    }

    @Override
    public Population getPopulation() {
        return Population.DEER;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case DEER, BOAR, BUFFALO, CATERPILLAR, DUCK, GOAT, HORSE, MOUSE, RABBIT, SHEEP, BEAR, BOA, EAGLE, FOX, WOLF -> {
                return false;
            }
            case PLANT -> chanceToEat = PopulationSettings.deerChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
