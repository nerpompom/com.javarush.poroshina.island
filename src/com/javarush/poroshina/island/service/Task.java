package com.javarush.poroshina.island.service;

import com.javarush.poroshina.island.entity.island.Island;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.animal.Animal;
import com.javarush.poroshina.island.entity.population.plant.Plant;

import java.util.List;
import java.util.Objects;

public class Task implements Runnable{

    private final Eatable eatable;
    private final Location location;
    private final List<Eatable> eatables;


    public Task(Eatable eatable, Location location, List<Eatable> eatables) {
        this.eatable = eatable;
        this.location = location;
        this.eatables = eatables;
    }

    @Override
    public void run() {
        if (eatable instanceof Animal animal && eatable != null) {
            animal.eat(location, eatables);
        }


        Eatable.populationDie(eatables);




//        if (eatable instanceof Animal animal && eatable != null) {
//            animal.eat(location);
//            animal.multiply(location);
//            animal.move(location);
//        }
//        Eatable.populationDie(location);
//
//        if (eatable instanceof Plant plant && eatable != null) {
//            plant.grow(location);
//        }
    }

    public void doTack() {

        System.out.println("ДЕЛАЮ ТАСКУ");
//        может проверку на ноль куда-то выше запихнуть?
//        if (eatable instanceof Animal animal && eatable != null) {
//            animal.eat(location);
//           animal.multiply(location);
//            animal.move(location);
//        }
//        Eatable.populationDie(location);
//
//        if (eatable instanceof Plant plant && eatable != null) {
//            plant.grow(location);
//        }
    }
}
