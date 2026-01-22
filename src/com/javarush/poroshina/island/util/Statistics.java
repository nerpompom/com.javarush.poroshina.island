package com.javarush.poroshina.island.util;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.entity.population.animal.herbivore.*;
import com.javarush.poroshina.island.entity.population.animal.predator.*;
import com.javarush.poroshina.island.entity.population.plant.Plant;
import com.javarush.poroshina.island.view.ConsoleView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Statistics {
    private static Map<Population, Integer> islandStatistics = new HashMap<>();
    private static AtomicInteger day = new AtomicInteger(1);

    public static void cleanStatistics() {
        islandStatistics.put(Population.BOAR, 0);
        islandStatistics.put(Population.BUFFALO, 0);
        islandStatistics.put(Population.CATERPILLAR, 0);
        islandStatistics.put(Population.DEER, 0);
        islandStatistics.put(Population.DUCK, 0);
        islandStatistics.put(Population.GOAT, 0);
        islandStatistics.put(Population.HORSE, 0);
        islandStatistics.put(Population.MOUSE, 0);
        islandStatistics.put(Population.RABBIT, 0);
        islandStatistics.put(Population.SHEEP, 0);
        islandStatistics.put(Population.BEAR, 0);
        islandStatistics.put(Population.BOA, 0);
        islandStatistics.put(Population.EAGLE, 0);
        islandStatistics.put(Population.FOX, 0);
        islandStatistics.put(Population.WOLF, 0);
        islandStatistics.put(Population.PLANT, 0);
    }

    public static void getStatistics(List<Eatable> population) {
        collectStatistics(population);
        printStatistics();
    }

    public static void collectStatistics(List<Eatable> population) {
        for (Eatable eatable : population) {

            if (eatable != null) {
                if (eatable instanceof Boar) {
                    islandStatistics.put(Population.BOAR, (islandStatistics.get(Population.BOAR) + 1));
                } else if (eatable instanceof Buffalo) {
                    islandStatistics.put(Population.BUFFALO, islandStatistics.get(Population.BUFFALO) + 1);
                } else if (eatable instanceof Caterpillar) {
                    islandStatistics.put(Population.CATERPILLAR, islandStatistics.get(Population.CATERPILLAR) + 1);
                } else if (eatable instanceof Deer) {
                    islandStatistics.put(Population.DEER, islandStatistics.get(Population.DEER) + 1);
                } else if (eatable instanceof Duck) {
                    islandStatistics.put(Population.DUCK, islandStatistics.get(Population.DUCK) + 1);
                } else if (eatable instanceof Goat) {
                    islandStatistics.put(Population.GOAT, islandStatistics.get(Population.GOAT) + 1);
                } else if (eatable instanceof Horse) {
                    islandStatistics.put(Population.HORSE, islandStatistics.get(Population.HORSE) + 1);
                } else if (eatable instanceof Mouse) {
                    islandStatistics.put(Population.MOUSE, islandStatistics.get(Population.MOUSE) + 1);
                } else if (eatable instanceof Rabbit) {
                    islandStatistics.put(Population.RABBIT, islandStatistics.get(Population.RABBIT) + 1);
                } else if (eatable instanceof Sheep) {
                    islandStatistics.put(Population.SHEEP, islandStatistics.get(Population.SHEEP) + 1);
                } else if (eatable instanceof Bear) {
                    islandStatistics.put(Population.BEAR, islandStatistics.get(Population.BEAR) + 1);
                } else if (eatable instanceof Boa) {
                    islandStatistics.put(Population.BOA, islandStatistics.get(Population.BOA) + 1);
                } else if (eatable instanceof Eagle) {
                    islandStatistics.put(Population.EAGLE, islandStatistics.get(Population.EAGLE) + 1);
                } else if (eatable instanceof Fox) {
                    islandStatistics.put(Population.FOX, islandStatistics.get(Population.FOX) + 1);
                } else if (eatable instanceof Wolf) {
                    islandStatistics.put(Population.WOLF, islandStatistics.get(Population.WOLF) + 1);
                } else if (eatable instanceof Plant) {
                    islandStatistics.put(Population.PLANT, islandStatistics.get(Population.PLANT) + 1);
                }
            }

        }
    }

    public static void printStatistics() {
        Map<String, Integer> pictureStatistics = new HashMap<>();

        for (Map.Entry<Population, Integer> element : islandStatistics.entrySet()) {
            String picture = ConsoleView.getPicture(element.getKey());
            pictureStatistics.put(picture, element.getValue());
        }
        System.out.println("День: " + day.getAndIncrement());
        System.out.println(pictureStatistics);
        cleanStatistics();
    }
}

