package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> listString = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            listString.add(reader.readLine());
        }

        for (int i = 0; i < 13; i++) {
            listString.add(0, listString.get(listString.size()-1));
            listString.remove(listString.size()-1);
        }

        for (String list : listString) {
            System.out.println(list);
        }
    }
}
