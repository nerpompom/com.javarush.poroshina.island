package com.javarush.poroshina.island.entity.island;

import com.javarush.poroshina.island.config.Settings;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.util.Statistics;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Island {

    private static Island instance;
    final private Location[][] locations;
    private List<Eatable> population;


    private Island(){
        this.locations = new Location[Settings.xSize][Settings.ySize];
        this.population = new CopyOnWriteArrayList<>();
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

    public Location[][] createLocations() {
        for (int i = 0; i < Settings.xSize; i++) {
            for (int j = 0; j < Settings.ySize; j++) {
                locations[i][j] = new Location(i, j);
            }
        }
        return locations;
    }

    public void generateIslandPopulation(Location[][] locations, List<Eatable> population) {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].generatePlantPopulation(locations[i][j].getLocationPopulation());
                locations[i][j].generateHerbivoryPopulation(locations[i][j].getLocationPopulation());
                locations[i][j].generatePredatorPopulation(locations[i][j].getLocationPopulation());
            }
            collectIslandPopulation(locations, population);
        }
    }

    //метод, который должен подсобирать актуальную инфу по популяции с каждой локации. Куда его вставить?
    public static void collectIslandPopulation(Location[][] locations, List<Eatable> population) {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                population.addAll(locations[i][j].getLocationPopulation());
            }
        }
    }

}
