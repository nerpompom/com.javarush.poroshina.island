package com.javarush.poroshina.island.entity.population.animal.herbivore;

import com.javarush.poroshina.island.entity.population.animal.Animal;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.island.Location;
import java.util.List;
import java.util.stream.IntStream;

public abstract class Herbivore extends Animal {

    public Herbivore(Location location, double weight, double full, int speed) {
        super(location, weight, full, speed);
        setBeEaten(false);
        setCurrentFull(0);
    }

    @Override
    public void multiply(Location location, List<Eatable> eatables) {
        location.getLock().lock();

        IntStream.range(0, 3)
                .mapToObj(i -> location.getHerbivoreFactory().create(this.getPopulation(), location))
                .forEach(eatables::add);

        this.setReadyToMultiply(false);

        location.getLock().unlock();
    }
}
