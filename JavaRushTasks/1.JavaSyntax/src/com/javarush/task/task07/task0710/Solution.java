package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> listString = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listString.add(0, reader.readLine());
        }

        for (String conclusion : listString) {
            System.out.println(conclusion);
        }
    }
}
