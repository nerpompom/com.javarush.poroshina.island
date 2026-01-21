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

//внутри кода каждого метода животных добавить блокировку на момент работы метода

public abstract class Animal implements Eatable {

//    есть растения и/или других животных (если в их локации есть подходящая еда),
//    передвигаться (в соседние локации),
//    размножаться (при наличии пары в их локации),
//    умирать от голода или быть съеденными.

    public Location location;
    double weight;
    double full;
    double currentFull;
    int speed;
    boolean beEaten;

    public Animal(Location location, double weight, double full, int speed) {
        this.location = location;
        this.weight = weight;
        this.full = full;
        this.speed = speed;
        setBeEaten(false);
        setCurrentFull(0);
    }

    @Override
    public boolean isBeEaten() {
        return beEaten;
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
        //надо ли тут лочить?
        return null;

    }


    public abstract void multiply(Location location);


    public abstract boolean canEat(Population name);

    public void eat(Location location) {
        location.getLock().lock();
        List<Eatable> food = location.getLocationPopulation();

        List<Eatable> filteredFood = food.stream()
                .filter(Objects::nonNull)
                .filter(eatable -> canEat(eatable.getPopulation()))
                .collect(Collectors.toList());

        for (Eatable eatable : filteredFood) {
            if (eatable instanceof Plant) {
                currentFull += (((Plant) eatable).getWeight()) / 2;
                weight += (currentFull / 2);
                ((Plant) eatable).setBeEaten(true);
            }
            if (eatable instanceof Animal) {
                currentFull += (((Animal) eatable).getWeight()) / 2;
                weight += (currentFull / 2);
                ((Animal) eatable).setBeEaten(true);
            }
        }
        location.getLock().unlock();
    }

    private char getDivision() {
        boolean division = Random.getRandomBoolean();
        if (division) {
            return 'X';
        } else {
            return 'Y';
        }
    }


    //рандомно двигаться?
    public void move(Location location) {
        location.getLock().lock();
        Location[][] locations = Island.getInstance().getLocations();
        int currentX = location.getX();
        int currentY = location.getY();

        int newX = currentX;
        int newY = currentY;

        //Идем вверх или вниз
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
