package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Deer extends Herbivore {
    public Deer(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }

    @Override
    public boolean canEat(Population name) {

        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.deerChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.deerChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.deerChanceEatCaterpillar;
            case DEER -> {
                return false;
            }
            case DUCK -> chanceToEat = PopulationSettings.deerChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.deerChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.deerChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.deerChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.deerChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.deerChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.deerChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.deerChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.deerChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.deerChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.deerChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.deerChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);

        return actual < chanceToEat;
    }

    @Override
    public Population getPopulation() {
        return Population.DEER;
    }

    @Override
    public void move(Location location) {

    }

}
