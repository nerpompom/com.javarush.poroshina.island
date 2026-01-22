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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

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

    public void createHerbivory(List<Eatable> locationPopulation) {
        ConcurrentHashMap<Population, Integer> maxCounts = new ConcurrentHashMap<>();

        maxCounts.put(Population.BOAR, PopulationSettings.maxBoarCount);
        maxCounts.put(Population.BUFFALO, PopulationSettings.maxBuffaloCount);
        maxCounts.put(Population.DEER, PopulationSettings.maxDeerCount);
        maxCounts.put(Population.DUCK, PopulationSettings.maxDuckCount);
        maxCounts.put(Population.GOAT, PopulationSettings.maxGoatCount);
        maxCounts.put(Population.HORSE, PopulationSettings.maxHorseCount);
        maxCounts.put(Population.MOUSE, PopulationSettings.maxMouseCount);
        maxCounts.put(Population.RABBIT, PopulationSettings.maxRabbitCount);
        maxCounts.put(Population.CATERPILLAR, PopulationSettings.maxCaterpillarCount);
        maxCounts.put(Population.SHEEP, PopulationSettings.maxSheepCount);

        double factor = Random.startFactor;
        maxCounts.entrySet().parallelStream()
                .forEach(entry -> {
                    Population population = entry.getKey();
                    int maxCount = entry.getValue();
                    int count = (int) (maxCount * factor);
                    IntStream.range(0, count)
                            .mapToObj(i -> herbivoreFactory.create(population, currentLocation))
                            .forEach(locationPopulation::add);
                });
    }

    public void createPredator(List<Eatable> locationPopulation) {
        ConcurrentHashMap<Population, Integer> maxCounts = new ConcurrentHashMap<>();

        maxCounts.put(Population.BEAR, PopulationSettings.maxBearCount);
        maxCounts.put(Population.BOA, PopulationSettings.maxBoaCount);
        maxCounts.put(Population.EAGLE, PopulationSettings.maxEagleCount);
        maxCounts.put(Population.FOX, PopulationSettings.maxFoxCount);
        maxCounts.put(Population.WOLF, PopulationSettings.maxWolfCount);

        double factor = Random.startFactor;
        maxCounts.entrySet().parallelStream()
                .forEach(entry -> {
                    Population population = entry.getKey();
                    int maxCount = entry.getValue();
                    int count = (int) (maxCount * factor);
                    IntStream.range(0, count)
                            .mapToObj(i -> predatorfactory.create(population, currentLocation))
                            .forEach(locationPopulation::add);
                });
    }

    public void createPlant(List<Eatable> locationPopulation) {
        double factor = Random.startFactor;
        int count = (int) (PopulationSettings.maxPlantCount * factor);

        IntStream.range(0, count)
                .mapToObj(i -> plantFactory.create(Population.PLANT, currentLocation))
                .forEach(locationPopulation::add);
    }
}
