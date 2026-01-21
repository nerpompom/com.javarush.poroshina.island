package com.javarush.poroshina.island.service;

import com.javarush.poroshina.island.entity.island.Island;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LocationWorker implements Runnable {

    Queue<Task> tasks;
    Location[][] locations;

    public LocationWorker(Location[][] locations) {
        this.locations = locations;
        tasks = new LinkedBlockingQueue<>();
    }

    @Override
    public void run() {
        //Посмотреть как для острова получаем инфу, актуально ли?
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                Queue<Task> locationTasks = locationCreateTasks(locations[i][j], tasks);
                locationDoTasks(locationTasks);
            }
        }
    }

    private Queue<Task> locationCreateTasks(Location location, Queue<Task> tasks) {

        location.getLock().lock();
        List<Eatable> locationPopulation = location.getLocationPopulation();
        //было !locationPopulation.isEmpty()
        if (locationPopulation != null) {
            try {
                for (Eatable eatable : locationPopulation) {
                    tasks.add(new Task(eatable, location));
                }
            } finally {
                location.getLock().unlock();
            }
        }
        return tasks;
    }

    private void locationDoTasks(Queue<Task> tasks) {
        for (Task task : tasks) {
            task.doTack();
        }
        tasks.clear();
    }
}
