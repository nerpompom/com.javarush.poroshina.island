package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Goat extends Herbivore {
    public Goat(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxGoatCount;
    }

    @Override
    public boolean canEat(Population name) {

        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.goatChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.goatChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.goatChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.goatChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.goatChanceEatDuck;
            case GOAT -> {
                return false;
            }
            case HORSE -> chanceToEat = PopulationSettings.goatChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.goatChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.goatChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.goatChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.goatChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.goatChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.goatChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.goatChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.goatChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.goatChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);

        return actual < chanceToEat;
    }

    @Override
    public Population getPopulation() {
        return Population.GOAT;
    }

    @Override
    public void move(Location location) {

    }

}
