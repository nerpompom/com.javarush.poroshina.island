package com.javarush.poroshina.island.entity.population.animal;

import com.javarush.poroshina.island.config.Settings;
import com.javarush.poroshina.island.entity.island.Island;
import com.javarush.poroshina.island.entity.island.Location;
import com.javarush.poroshina.island.entity.population.Eatable;
import com.javarush.poroshina.island.entity.population.Population;
import com.javarush.poroshina.island.entity.population.plant.Plant;
import com.javarush.poroshina.island.util.Random;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public abstract class Animal implements Eatable {

    public Location location;
    double weight;
    double full;
    double currentFull;
    int speed;
    boolean beEaten;
    boolean readyToMultiply;
    boolean hungry;

    public Animal(Location location, double weight, double full, int speed) {
        this.location = location;
        this.weight = weight;
        this.full = full;
        this.speed = speed;
        setBeEaten(false);
        setCurrentFull(0);
        setReadyToMultiply(false);
        setHungry(false);
    }

    @Override
    public boolean isBeEaten() {
        return beEaten;
    }

    public double getCurrentFull() {
        return currentFull;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public void setReadyToMultiply(boolean readyToMultiply) {
        this.readyToMultiply = readyToMultiply;
    }

    public boolean isFull() {
        return currentFull > full;
    }

    public int getSpeed() {
        return speed;
    }

    public void setBeEaten(boolean beEaten) {
        this.beEaten = beEaten;
    }

    public void setCurrentFull(double currentFull) {
        this.currentFull = currentFull;
    }

    public double getFull() {
        return full;
    }

    public void setFull(double full) {
        this.full = full;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Eatable die() {
        return null;
    }

    public abstract int getMaxCount();

    public abstract void multiply(Location location, List<Eatable> eatables);

    public abstract boolean canEat(Population name);

    public boolean eat(Location location, List<Eatable> food) {
        location.getLock().lock();

        List<Eatable> actualFood = food.stream()
                .filter(Objects::nonNull)
                .filter(eatable -> canEat(eatable.getPopulation()))
                .collect(Collectors.toList());

            actualFood.forEach(eatable -> {
                if (eatable instanceof Plant) {
                    this.setCurrentFull(this.getFull());
                    ((Plant) eatable).setBeEaten(Random.getRandomBoolean());
                    setHungry(Random.getRandomBoolean());
                } else if (eatable instanceof Animal) {
                    this.setCurrentFull(this.getFull());
                    ((Animal) eatable).setBeEaten(Random.getRandomBoolean());
                    setHungry(Random.getRandomBoolean());
                } else {
                    setHungry(true);
                }
            });
        location.getLock().unlock();
        return this.isHungry();
    }

    private char getDivision() {
        boolean division = Random.getRandomBoolean();
        if (division) {
            return 'X';
        } else {
            return 'Y';
        }
    }

    public void move(Location location) {
        location.getLock().lock();

        Location[][] locations = Island.getInstance().getLocations();
        int currentX = location.getX();
        int currentY = location.getY();

        int newX = currentX;
        int newY = currentY;

        switch (getDivision()) {
            case 'X' -> {
                if (currentX + speed < Settings.xSize) {
                    newX += speed;
                } else {
                    newX = (currentX + speed) - Settings.xSize;
                }
            }
            case 'Y' -> {
                if (currentY + speed < Settings.ySize) {
                    newY += speed;
                } else {
                    newY = (currentY + speed) - Settings.ySize;
                }
            }
        }

        location.setX(newX);
        location.setY(newY);

        location.getLock().unlock();
    }
}
