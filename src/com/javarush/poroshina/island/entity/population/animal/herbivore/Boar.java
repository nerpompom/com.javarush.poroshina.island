package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;

public class Boar extends Herbivore {

    public Boar(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }

    @Override
    public int getMaxCount() {
        return PopulationSettings.maxBoarCount;
    }

    @Override
    public Population getPopulation() {
        return Population.BOAR;
    }

    @Override
    public boolean canEat(Population name) {
        int chanceToEat = 0;

        switch (name) {
            case BOAR, BUFFALO, DEER, DUCK, GOAT, HORSE, RABBIT, SHEEP, BEAR, BOA, EAGLE, FOX, WOLF -> {
                return false;
            }
            case CATERPILLAR -> chanceToEat = PopulationSettings.boarChanceEatCaterpillar;
            case MOUSE -> chanceToEat = PopulationSettings.boarChanceEatMouse;
            case PLANT -> chanceToEat = PopulationSettings.boarChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);
        return actual < chanceToEat;
    }
}
