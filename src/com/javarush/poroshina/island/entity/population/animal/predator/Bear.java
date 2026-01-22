package com.javarush.poroshina.island.entity.population.animal.predator;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Bear extends Predator {
    public Bear(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxBearCount;
    }

    @Override
    public Population getPopulation() {
        return Population.BEAR;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.bearChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.bearChanceEatBuffalo;
            case DEER -> chanceToEat = PopulationSettings.bearChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.bearChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.bearChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.bearChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.bearChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.bearChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.bearChanceEatSheep;
            case BEAR, CATERPILLAR, EAGLE, FOX, WOLF, PLANT -> {
                return false;
            }
            case BOA -> chanceToEat = PopulationSettings.bearChanceEatBoa;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);

        return actual < chanceToEat;
    }
}
