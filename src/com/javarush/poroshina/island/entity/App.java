package com.javarush.poroshina.island.entity;

import com.javarush.poroshina.island.config.AppConstants;
import com.javarush.poroshina.island.entity.island.Island;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.service.Worker;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        System.out.println(AppConstants.START_MESSAGE);
        Island island = Island.getInstance();
        island.createLocations();
        Map<Location, List<Eatable>> islandMap = island.getIslandMap();
        island.generateStartPopulation(islandMap);

        Worker worker = new Worker(islandMap);
        worker.start();

        try {
            worker.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": " + AppConstants.THREAD_AWAIT_ERROR);
        }

        System.out.println(AppConstants.END_MESSAGE);
    }
}
