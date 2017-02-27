package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        int minLength;
        int maxLength = 0;
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        minLength = list.get(0).length();

        for (String printList : list) {
            if (printList.length() > maxLength) {
                maxLength = printList.length();
            }
            if (printList.length() < minLength) {
                minLength = printList.length();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == maxLength) {
                System.out.println(list.get(i));
                break;
            }else if (list.get(i).length() == minLength) {
                System.out.println(list.get(i));
                break;
            }
        }
    }
}
