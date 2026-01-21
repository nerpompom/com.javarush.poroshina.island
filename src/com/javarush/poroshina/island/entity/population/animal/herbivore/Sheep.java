package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Sheep extends Herbivore {
    public Sheep(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }

    @Override
    public boolean canEat(Population name) {

        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.sheepChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.sheepChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.sheepChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.sheepChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.sheepChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.sheepChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.sheepChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.sheepChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.sheepChanceEatRabbit;
            case SHEEP -> {
                return false;
            }
            case BEAR -> chanceToEat = PopulationSettings.sheepChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.sheepChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.sheepChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.sheepChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.sheepChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.sheepChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);

        return actual < chanceToEat;
    }

    @Override
    public Population getPopulation() {
        return Population.SHEEP;
    }

    @Override
    public void move(Location location) {

    }

}
