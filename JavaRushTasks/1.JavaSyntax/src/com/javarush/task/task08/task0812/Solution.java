package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int size;
        int result = 1;

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 1; i < list.size(); i++) {
            size = 1;
            if (list.get(i) == list.get(i-1)) {
                while (list.get(i) == list.get(i-1)) {
                    size++;
                    i++;
                    if (i > 9) {
                        break;
                    }
                }
            }
            if (result < size) {
                result = size;
            }
        }

        System.out.println(result);



    }
}