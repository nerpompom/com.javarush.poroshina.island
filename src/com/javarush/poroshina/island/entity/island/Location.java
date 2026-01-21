package com.javarush.poroshina.island.entity.island;

import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.animal.herbivore.Boar;
import com.javarush.poroshina.island.repository.Factory;
import com.javarush.poroshina.island.repository.HerbivoreFactory;
import com.javarush.poroshina.island.repository.PlantFactory;
import com.javarush.poroshina.island.repository.PredatorFactory;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.util.Random;
import com.javarush.poroshina.island.util.Statistics;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Location {

    int x;
    int y;
    private List<Eatable> locationPopulation = new CopyOnWriteArrayList<>();
    private HerbivoreFactory herbivoreFactory;
    private PredatorFactory predatorfactory;
    private PlantFactory plantFactory;
    Location currentLocation;
    private final Lock lock = new ReentrantLock();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        Location[][] locations = Island.getInstance().getLocations();
        this.currentLocation = locations[x][y];
        this.herbivoreFactory = new HerbivoreFactory();
        this.predatorfactory = new PredatorFactory();
        this.plantFactory = new PlantFactory();
    }

    public Lock getLock() {
        return lock;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //нужно ли в методе лочить?
    public List<Eatable> getLocationPopulation() {
        return locationPopulation;
    }

    public HerbivoreFactory getHerbivoreFactory() {
        return herbivoreFactory;
    }

    public PredatorFactory getPredatorfactory() {
        return predatorfactory;
    }

    public PlantFactory getPlantFactory() {
        return plantFactory;
    }

    public void generateHerbivoryPopulation(List<Eatable> locationPopulation) {
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxBoarCount * Random.startFactor), Population.BOAR, herbivoreFactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxBuffaloCount * Random.startFactor), Population.BUFFALO, herbivoreFactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxCaterpillarCount * Random.startFactor), Population.CATERPILLAR, herbivoreFactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxDeerCount * Random.startFactor), Population.DEER, herbivoreFactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxDuckCount * Random.startFactor), Population.DUCK, herbivoreFactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxGoatCount * Random.startFactor), Population.GOAT, herbivoreFactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxHorseCount * Random.startFactor), Population.HORSE, herbivoreFactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxMouseCount * Random.startFactor), Population.MOUSE, herbivoreFactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxRabbitCount * Random.startFactor), Population.RABBIT, herbivoreFactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxSheepCount * Random.startFactor), Population.SHEEP, herbivoreFactory, locationPopulation);
    }

    public void generatePredatorPopulation(List<Eatable> locationPopulation) {
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxBearCount * Random.startFactor), Population.BEAR, predatorfactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxBoaCount * Random.startFactor), Population.BOA, predatorfactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxEagleCount * Random.startFactor), Population.EAGLE, predatorfactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxFoxCount * Random.startFactor), Population.FOX, predatorfactory, locationPopulation);
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxWolfCount * Random.startFactor), Population.WOLF, predatorfactory, locationPopulation);

    }

    public void generatePlantPopulation(List<Eatable> locationPopulation) {
        generateRandomSpecimen(Random.getRandomInt(PopulationSettings.maxPlantCount * Random.startFactor), Population.PLANT, plantFactory, locationPopulation);
    }

    private void generateRandomSpecimen(int random, Population name, Factory factory, List<Eatable> locationPopulation) {
        if (currentNameCount(name) < Statistics.eatableMaxNumber(name)) {
            for (int i = 0; i < random; i++) {
                locationPopulation.add(factory.create(name, currentLocation));
            }
        }
    }

    //Разобраться в этом методе
    public int currentNameCount(Population name) {
        return (int) locationPopulation.stream()
                .filter(eatable -> eatable.getPopulation().equals(name))
                .count();
    }
}

