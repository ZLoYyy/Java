package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        int index = 1;
        while (index == 1){
            String str = reader.readLine();

            if (str.equals("end")){
                index = 0;
            }else {
                list.add(str);
            }
        }
        for (String x : list) {
            System.out.println(x);
        }
    }
}