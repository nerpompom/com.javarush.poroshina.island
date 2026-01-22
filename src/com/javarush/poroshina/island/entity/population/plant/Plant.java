package com.javarush.poroshina.island.entity.population.plant;

import com.javarush.poroshina.island.config.PopulationSettings;
import com.javarush.poroshina.island.config.Settings;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.util.Random;
import com.javarush.poroshina.island.util.Statistics;

import java.util.List;
import java.util.logging.LogManager;
import java.util.stream.IntStream;

public class Plant implements Eatable {

    Location location;
    double weight;
    boolean beEaten;

    public Plant(Location location, double weight) {
        this.location = location;
        this.weight = weight;
        this.beEaten = false;
    }

    @Override
    public boolean isBeEaten() {
        return beEaten;
    }

    public double getWeight() {
        return weight;
    }

    public void setBeEaten(boolean beEaten) {
        this.beEaten = beEaten;
    }

    @Override
    public Population getPopulation() {
        return Population.PLANT;
    }

    @Override
    public Eatable die() {
        //надо ли тут лочить?
        return null;
    }


    public static void grow(Location location, List<Eatable> eatables) {

        location.getLock().lock();

        int count = (int) (PopulationSettings.maxPlantCount * Random.multiplyPlantFactor);

        IntStream.range(0, count)
                .mapToObj(i -> location.getPlantFactory().create(Population.PLANT, location))
                .forEach(eatables::add);

        location.getLock().unlock();
    }

//        location.getLock().lock();
//        List<Eatable> eatables = location.getLocationPopulation();
//
//        for (Eatable eatable : eatables) {
//           if (eatable instanceof Plant && ((location.currentNameCount(Population.PLANT) + 1) <= Indicator.eatableMaxNumber(Population.PLANT))) {
//               location.getLocationPopulation().add(location.getPlantFactory().create(Population.PLANT, location));
//            }
//            location.getLocationPopulation().add(location.getPlantFactory().create(Population.PLANT, location));
//        }

//        if (location.currentNameCount(Population.PLANT) < Indicator.animalMaxNumber(Population.PLANT)) {
//            int children = Random.getRandomInt(Indicator.animalMaxNumber(Population.PLANT) * Random.multiplyFactor);
//            if ((children + location.currentNameCount(Population.PLANT) >= Indicator.animalMaxNumber(Population.PLANT))) {
//                int difference = 0;
//                int left = Indicator.animalMaxNumber(Population.PLANT);
//                int right = location.currentNameCount(Population.PLANT);
//                difference = left - right;
//                for (int i = 0; i < difference; i++) {
//                    locationPopulation.add(location.getPlantFactory().create(Population.PLANT, location));
//                   // + надо чтобы в общий список острова
//                }
//            } else {
//                for (int i = 0; i < children; i++) {
//                    locationPopulation.add(location.getPlantFactory().create(Population.PLANT, location));
//                    // + надо чтобы в общий список острова
//                }
//            }
//        }
//        location.getLock().unlock();
//    }
}
