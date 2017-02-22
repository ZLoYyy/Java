package com.javarush.task.task07.task0703;



/*
Общение одиноких массивов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] chars = new String[10];
        int[] number = new int[10];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = reader.readLine();
        }

        for (int i = 0; i < number.length; i++) {
            number[i] = chars[i].length();
            System.out.println(number[i]);
        }


    }
}
