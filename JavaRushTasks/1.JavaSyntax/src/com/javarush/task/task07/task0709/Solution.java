package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int minLength = 0;
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }

        for (String minStr : list) {
            minLength = minStr.length();
            for (String string : list) {
                if (string.length() < minLength) {
                    minLength = string.length();
                }
            }
        }

        for (String str : list) {
            if (str.length() == minLength) {
                System.out.println(str);
            }
        }

    }
}
