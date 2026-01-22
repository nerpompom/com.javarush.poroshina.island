package com.javarush.poroshina.island.entity.population.animal.predator;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Wolf extends Predator {
    public Wolf(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxWolfCount;
    }

    @Override
    public Population getPopulation() {
        return Population.WOLF;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.wolfChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.wolfChanceEatBuffalo;
            case DEER -> chanceToEat = PopulationSettings.wolfChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.wolfChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.wolfChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.wolfChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.wolfChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.wolfChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.wolfChanceEatSheep;
            case WOLF, CATERPILLAR, BEAR, BOA, EAGLE, FOX -> {
                return false;
            }
            case PLANT -> chanceToEat = PopulationSettings.wolfChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
