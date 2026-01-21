package com.javarush.poroshina.island.entity.population.plant;

import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.Population;

import java.util.List;

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


    public void grow(Location location) {

        location.getLock().lock();


        //Проблемки с логикой роста растений !!!!! БОЛЬШАЯ ЛОГИКА ПОЧЕМУ-ТО НЕ ПОЗВОЛЯЕТ НИТЯМ ЗАКОНЧИТЬ РАБОТУ
        List<Eatable> locationPopulation = location.getLocationPopulation();
        locationPopulation.add(location.getPlantFactory().create(getPopulation(), location));
//            if (location.currentNameCount(getPopulation()) < Indicator.eatableMaxNumber(getPopulation())) {
//                int children = Random.getRandomInt(Indicator.eatableMaxNumber(getPopulation()) * Random.multiplyFactor);
//                if ((children + location.currentNameCount(getPopulation()) >= Indicator.eatableMaxNumber(getPopulation()))) {
//                    int difference = 0;
//                    int left = Indicator.eatableMaxNumber(getPopulation());
//                    int right = location.currentNameCount(getPopulation());
//                    difference = left - right;
//                    for (int i = 0; i < difference; i++) {
//                        //population.add(location.getPredatorfactory().create(getPopulation(), location));
//                        //надо позаботиться чтобы попадало в список острова
//                        locationPopulation.add(location.getPlantFactory().create(getPopulation(), location));
//                    }
//                } else {
//                    for (int i = 0; i < children; i++) {
//                        //population.add(location.getHerbivoreFactory().create(getPopulation(), location));
//                        //надо позаботиться чтобы попадало в список острова
//                        locationPopulation.add(location.getPlantFactory().create(getPopulation(), location));
//                    }
//                }
//            }

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
