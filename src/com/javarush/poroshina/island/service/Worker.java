package com.javarush.poroshina.island.service;

import com.javarush.poroshina.island.config.AppConstants;
import com.javarush.poroshina.island.config.Settings;
import com.javarush.poroshina.island.entity.island.Island;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.util.Statistics;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Worker extends Thread {

    Map<Location, List<Eatable>> islandMap;

    public Worker(Map<Location, List<Eatable>> islandMap) {
        this.islandMap = islandMap;
    }

    @Override
    public void run() {
        ScheduledExecutorService islandService = new ScheduledThreadPoolExecutor(Settings.CORE_POOL_SIZE);

        islandService.scheduleWithFixedDelay(() -> {
            ExecutorService taskExecutor = Executors.newFixedThreadPool(Settings.CORE_POOL_SIZE);
            islandMap.forEach((location, eatableList) -> {
                eatableList.forEach(eatable -> {
                    taskExecutor.submit(new Task(eatable, location, eatableList));
                });
            });

            Island.refreshPopulation(islandMap);


            taskExecutor.shutdown();
            try {
                taskExecutor.awaitTermination(1, TimeUnit.HOURS);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": " + AppConstants.THREAD_AWAIT_ERROR);
            }

            Statistics.getStatistics(Island.getInstance().getPopulation());
        }, Settings.INITIAL_DELAY, Settings.DELAY, TimeUnit.SECONDS);

        completePool(islandService);













//        ScheduledExecutorService islandService = new ScheduledThreadPoolExecutor(Settings.CORE_POOL_SIZE);
//
//        islandService.scheduleWithFixedDelay(() -> {
//
//            islandMap.forEach((location, eatableList) -> {
//                eatableList.forEach(eatable -> {
//                    Thread thread = new Thread(new Task(eatable, location));
//                    thread.start();
//                });
//            });
//
//            Statistics.getStatistics(Island.getInstance().getPopulation());
//        }, Settings.INITIAL_DELAY, Settings.DELAY, TimeUnit.SECONDS);
//
//        completePool(islandService);
    }

    private void completePool(ScheduledExecutorService islandService) {
        try {
            islandService.awaitTermination(Settings.SECONDS_OF_WORK, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": " + AppConstants.THREAD_AWAIT_ERROR);
            islandService.shutdownNow();
        }
        islandService.shutdownNow();
    }
}
