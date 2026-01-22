package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Buffalo extends Herbivore {

    public Buffalo(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxBuffaloCount;
    }

    @Override
    public boolean canEat(Population name) {

        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.buffaloChanceEatBoar;
            case BUFFALO -> {
                return false;
            }
            case CATERPILLAR -> chanceToEat = PopulationSettings.buffaloChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.buffaloChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.buffaloChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.buffaloChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.buffaloChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.buffaloChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.buffaloChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.buffaloChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.buffaloChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.buffaloChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.buffaloChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.buffaloChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.buffaloChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.buffaloChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);

        return actual < chanceToEat;
    }

    @Override
    public Population getPopulation() {
        return Population.BUFFALO;
    }

    @Override
    public void move(Location location) {

    }
}
