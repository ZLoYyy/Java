package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList list = new ArrayList();
        int number;
        float sum = 0;
        float result;

        while ((number = Integer.parseInt(reader.readLine())) != -1) {
            list.add(number);
        }

        for (int i = 0; i < list.size() ; i++) {
            sum += (int) list.get(i);
        }

        result = sum / list.size();
        System.out.println(result);
    }
}

