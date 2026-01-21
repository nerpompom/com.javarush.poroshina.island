package com.javarush.poroshina.island.entity;

import com.javarush.poroshina.island.config.AppConstants;
import com.javarush.poroshina.island.service.IslandWorker;
import com.javarush.poroshina.island.util.Statistics;

public class App {

    public static void main(String[] args) {
        System.out.println(AppConstants.START_MESSAGE);

        IslandWorker islandWorker = new IslandWorker();
        islandWorker.start();

        try {
            islandWorker.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": " + AppConstants.THREAD_AWAIT_ERROR);
        }

        System.out.println(AppConstants.END_MESSAGE);
        System.out.println(Statistics.getDay());
    }
}
