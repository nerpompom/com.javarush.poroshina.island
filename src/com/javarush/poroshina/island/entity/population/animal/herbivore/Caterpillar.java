package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Caterpillar extends Herbivore {
    public Caterpillar(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxCaterpillarCount;
    }

    @Override
    public Population getPopulation() {
        return Population.CATERPILLAR;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.caterpillarChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.caterpillarChanceEatBuffalo;
            case CATERPILLAR -> {
                return false;
            }
            case DEER -> chanceToEat = PopulationSettings.caterpillarChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.caterpillarChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.caterpillarChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.caterpillarChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.caterpillarChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.caterpillarChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.caterpillarChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.caterpillarChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.caterpillarChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.caterpillarChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.caterpillarChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.caterpillarChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.caterpillarChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
