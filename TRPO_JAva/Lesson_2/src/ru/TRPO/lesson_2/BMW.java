package ru.TRPO.lesson_2;

/**
 * Created by ((ZLoY)) on 04.11.2016.
 */
public class BMW extends Car {

    private String color;

    public BMW(String color) {
        this.color = color;
    }

    @Override
    public void report() {
        System.out.print(color + " ");
        super.report();
    }
}
