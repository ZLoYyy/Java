package ru.TRPO.lesson2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ((ZLoY)) on 04.11.2016.
 */
public class Driver
{
    public static String position;

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        position = reader.readLine();
    }
}
