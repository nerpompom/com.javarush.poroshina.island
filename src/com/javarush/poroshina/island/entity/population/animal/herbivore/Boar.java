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

    //может для травоядных доработать метод? с учетом что почти все по 0-лям
    @Override
    public boolean canEat(Population name) {

        int chanceToEat = 0;

        switch (name) {
            case BOAR -> {
                return false;
            }
            case BUFFALO -> chanceToEat = PopulationSettings.boarChanceEatBuffalo;
            case CATERPILLAR -> chanceToEat = PopulationSettings.boarChanceEatCaterpillar;
            case DEER -> chanceToEat = PopulationSettings.boarChanceEatDeer;
            case DUCK -> chanceToEat = PopulationSettings.boarChanceEatDuck;
            case GOAT -> chanceToEat = PopulationSettings.boarChanceEatGoat;
            case HORSE -> chanceToEat = PopulationSettings.boarChanceEatHorse;
            case MOUSE -> chanceToEat = PopulationSettings.boarChanceEatMouse;
            case RABBIT -> chanceToEat = PopulationSettings.boarChanceEatRabbit;
            case SHEEP -> chanceToEat = PopulationSettings.boarChanceEatSheep;
            case BEAR -> chanceToEat = PopulationSettings.boarChanceEatBear;
            case BOA -> chanceToEat = PopulationSettings.boarChanceEatBoa;
            case EAGLE -> chanceToEat = PopulationSettings.boarChanceEatEagle;
            case FOX -> chanceToEat = PopulationSettings.boarChanceEatFox;
            case WOLF -> chanceToEat = PopulationSettings.boarChanceEatWolf;
            case PLANT -> chanceToEat = PopulationSettings.boarChanceEatPlant;
        }

        int actual = Random.getRandomInt(Random.minChance, Random.maxChance);

        return actual < chanceToEat;
    }

    @Override
    public Population getPopulation() {
        return Population.BOAR;
    }



    @Override
    public void move(Location location) {

    }

}
