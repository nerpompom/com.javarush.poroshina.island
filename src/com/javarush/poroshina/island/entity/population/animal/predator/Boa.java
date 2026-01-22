package com.javarush.poroshina.island.entity.population.animal.predator;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Boa extends Predator {
    public Boa(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxBoaCount;
    }

    @Override
    public Population getPopulation() {
        return Population.BOA;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case DUCK -> chanceToEat = PopulationSettings.boaChanceEatDuck;
            case MOUSE -> chanceToEat = PopulationSettings.boaChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.boaChanceEatRabbit;
            case BOA, BOAR, BUFFALO, CATERPILLAR, DEER, GOAT, HORSE, SHEEP, BEAR, EAGLE, WOLF, PLANT -> {
                return false;
            }
            case FOX -> chanceToEat = PopulationSettings.boaChanceEatFox;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
