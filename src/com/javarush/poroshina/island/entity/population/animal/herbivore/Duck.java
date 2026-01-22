package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Duck extends Herbivore {
    public Duck(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxDuckCount;
    }

    @Override
    public Population getPopulation() {
        return Population.DUCK;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.duckChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.duckChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.duckChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.duckChanceEatDeer;
            case DUCK -> {
                return false;
            }
            case GOAT -> chanceToEat = PopulationSettings.duckChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.duckChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.duckChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.duckChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.duckChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.duckChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.duckChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.duckChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.duckChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.duckChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.duckChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
