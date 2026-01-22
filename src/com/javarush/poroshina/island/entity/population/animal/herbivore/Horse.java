package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Horse extends Herbivore {
    public Horse(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxHorseCount;
    }

    @Override
    public Population getPopulation() {
        return Population.HORSE;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.horseChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.horseChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.horseChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.horseChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.horseChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.horseChanceEatGoat;
            case HORSE -> {
                return false;
            }
            case MOUSE -> chanceToEat = PopulationSettings.horseChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.horseChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.horseChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.horseChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.horseChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.horseChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.horseChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.horseChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.horseChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
