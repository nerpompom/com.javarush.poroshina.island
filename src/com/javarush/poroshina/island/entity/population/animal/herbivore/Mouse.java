package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Mouse extends Herbivore {
    public Mouse(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }
    @Override
    public int getMaxCount() {
        return PopulationSettings.maxMouseCount;
    }

    @Override
    public Population getPopulation() {
        return Population.MOUSE;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case BOAR -> chanceToEat = PopulationSettings.mouseChanceEatBoar;
            case BUFFALO -> chanceToEat = PopulationSettings.mouseChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.mouseChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.mouseChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.mouseChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.mouseChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.mouseChanceEatHorse;
            case MOUSE -> {
                return false;
            }
            case RABBIT -> chanceToEat = PopulationSettings.mouseChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.mouseChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.mouseChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.mouseChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.mouseChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.mouseChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.mouseChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.mouseChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
