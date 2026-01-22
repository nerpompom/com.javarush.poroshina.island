package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Rabbit extends Herbivore {
    public Rabbit(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxRabbitCount;
    }

    @Override
    public Population getPopulation() {
        return Population.RABBIT;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.rabbitChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.rabbitChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.rabbitChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.rabbitChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.rabbitChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.rabbitChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.rabbitChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.rabbitChanceEatMouse;
            case RABBIT -> {
                return false;
            }
            case SHEEP -> chanceToEat = PopulationSettings.rabbitChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.rabbitChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.rabbitChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.rabbitChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.rabbitChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.rabbitChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.rabbitChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
