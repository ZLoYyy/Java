package ru.TRPO.lesson2;

public class Car {

    public void start()
    {
        System.out.println("car is started");
    }

    public void stop()
    {
        System.out.println("car is stopped");
    }

    public void report(int position)
    {
        if(position == 0)
            System.out.println("car is stopped");
        else
            System.out.println("car is started");
    }



}
