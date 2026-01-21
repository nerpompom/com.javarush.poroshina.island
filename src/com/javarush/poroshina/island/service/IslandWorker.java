package com.javarush.poroshina.island.service;

import com.javarush.poroshina.island.config.AppConstants;
import com.javarush.poroshina.island.config.Settings;
import com.javarush.poroshina.island.entity.island.Island;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.util.Statistics;

import java.util.List;
import java.util.concurrent.*;

public class IslandWorker extends Thread {

    private ScheduledExecutorService islandService;

    @Override
    public void run() {
        Island island = Island.getInstance();
        Location[][] locations = island.createLocations();
        List<Eatable> population = island.getPopulation();
        island.generateIslandPopulation(locations, population);

        islandService = new ScheduledThreadPoolExecutor(Settings.CORE_POOL_SIZE);

        List<LocationWorker> workers = new CopyOnWriteArrayList<>();
        for (int i = 0; i < Settings.CORE_POOL_SIZE; i++) {
            workers.add(new LocationWorker(locations));
        }

        islandService.scheduleWithFixedDelay(() -> {
            runWorkers(workers);
            Statistics.getStatistics(population);
        }, Settings.INITIAL_DELAY, Settings.DELAY, TimeUnit.SECONDS);

        completePool(islandService);
    }

    private void runWorkers(List<LocationWorker> workers) {
        List<Thread> threads = new CopyOnWriteArrayList<>();

        for (LocationWorker worker : workers) {
            Thread dayService = new Thread(worker);
            threads.add(dayService);
            dayService.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": " + AppConstants.THREAD_AWAIT_ERROR);
            }
        }
    }

    private void completePool(ScheduledExecutorService islandService) {
        try {
            islandService.awaitTermination(Settings.DAYS_ON_THE_ISLAND, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": " + AppConstants.THREAD_AWAIT_ERROR);
            islandService.shutdownNow();
        }
        islandService.shutdownNow();
    }


//        ExecutorService executorService = Executors.newFixedThreadPool(IslandSettings.CORE_POOL_SIZE);
//        for (LocationWorker worker : workers) {
//            executorService.execute(worker);
//            //executorService.shutdown();
//            try {
//                executorService.awaitTermination(5000, TimeUnit.SECONDS);
//            } catch (InterruptedException e) {
}
