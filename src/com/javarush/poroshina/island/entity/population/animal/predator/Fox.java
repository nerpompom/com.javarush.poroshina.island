package com.javarush.poroshina.island.entity.population.animal.predator;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Fox extends Predator {
    public Fox(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxFoxCount;
    }
    @Override
    public Population getPopulation() {
        return Population.FOX;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.foxChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.foxChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.foxChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.foxChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.foxChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.foxChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.foxChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.foxChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.foxChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.foxChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.foxChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.foxChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.foxChanceEatEagle;
            case FOX -> {
                return false;
            }
            case WOLF -> chanceToEat = PopulationSettings.foxChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.foxChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
