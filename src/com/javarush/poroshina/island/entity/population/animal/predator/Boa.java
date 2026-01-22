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
            case BOAR -> chanceToEat = PopulationSettings.boaChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.boaChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.boaChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.boaChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.boaChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.boaChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.boaChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.boaChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.boaChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.boaChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.boaChanceEatBear;
            case BOA -> {
                return false;
            }
            case EAGLE -> chanceToEat = PopulationSettings.boaChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.boaChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.boaChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.boaChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
