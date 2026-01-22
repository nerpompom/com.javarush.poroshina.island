package com.javarush.poroshina.island.entity.island;

import com.javarush.poroshina.island.config.Settings;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.util.Statistics;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Island {

    private static Island instance;
    final private Location[][] locations;
    private List<Eatable> population;
    Map<Location, List<Eatable>> islandMap;


    private Island() {
        this.locations = new Location[Settings.xSize][Settings.ySize];
        this.population = new CopyOnWriteArrayList<>();
        this.islandMap = new ConcurrentHashMap<>();
        Statistics.cleanStatistics();
    }

    public Location[][] getLocations() {
        return locations;
    }

    public List<Eatable> getPopulation() {
        return population;
    }

    public static Island getInstance() {
        if (instance == null) {
            instance = new Island();
        }
        return instance;
    }

    public Map<Location, List<Eatable>> getIslandMap() {
        return islandMap;
    }

    public void createLocations() {
        for (int i = 0; i < Settings.xSize; i++) {
            for (int j = 0; j < Settings.ySize; j++) {
                Location currentLocation = new Location(i, j);
                List<Eatable> locationPopulation = currentLocation.getLocationPopulation();
                islandMap.put(currentLocation, locationPopulation);
            }
        }
    }

    public void generateStartPopulation(Map<Location, List<Eatable>> islandMap) {
        islandMap.forEach((location, locationPopulation) -> {
            location.createPlant(locationPopulation);
            location.createHerbivory(locationPopulation);
            location.createPredator(locationPopulation);
            collectIslandPopulation(this.islandMap, population);
        });
    }

    public static void collectIslandPopulation(Map<Location, List<Eatable>> myIsland, List<Eatable> population) {
        myIsland.values().forEach(population::addAll);
    }

    public static void refreshPopulation(Map<Location, List<Eatable>> islandMap, List<Eatable> population) {
        islandMap.forEach((location, oldPopulation) -> {
            List<Eatable> updatedPopulation = location.getLocationPopulation();
            islandMap.put(location, updatedPopulation);
        });

        population.clear();
        islandMap.values().forEach(population::addAll);
    }

}
