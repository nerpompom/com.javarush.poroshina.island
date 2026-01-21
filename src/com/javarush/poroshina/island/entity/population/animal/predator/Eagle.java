package com.javarush.poroshina.island.entity.population.animal.predator;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Eagle extends Predator {
    public Eagle(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }

    @Override
    public boolean canEat(Population name) {

        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.eagleChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.eagleChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.eagleChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.eagleChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.eagleChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.eagleChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.eagleChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.eagleChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.eagleChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.eagleChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.eagleChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.eagleChanceEatBoa;
            case EAGLE -> {
                return false;
            }
            case FOX -> chanceToEat = PopulationSettings.eagleChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.eagleChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.eagleChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);

        return actual < chanceToEat;
    }

    @Override
    public Population getPopulation() {
        return Population.EAGLE;
    }

}
