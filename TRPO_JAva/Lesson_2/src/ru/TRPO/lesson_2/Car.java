package ru.TRPO.lesson_2;

/**
 * Created by ((ZLoY)) on 04.11.2016.
 */
public class Car {
    private boolean power = false;

    public void start() {
        power = true;
    }

    public void stop() {
        power = false;
    }

    public void report() {
        if (power) {
            System.out.println("car is started");
        }
        else {
            System.out.println("car is stopped");
        }

    }
}
