package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Goat extends Herbivore {
    public Goat(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxGoatCount;
    }

    @Override
    public Population getPopulation() {
        return Population.GOAT;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case GOAT, BOAR, BUFFALO, CATERPILLAR, DEER, DUCK, HORSE, MOUSE, RABBIT, SHEEP, BEAR, BOA, EAGLE, FOX, WOLF -> {
                return false;
            }
            case PLANT -> chanceToEat = PopulationSettings.goatChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
