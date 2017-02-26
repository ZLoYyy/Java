package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listX2 = new ArrayList<>();
        ArrayList<Integer> listX3 = new ArrayList<>();
        ArrayList<Integer> listOther = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        for (Integer listAll : list) {
            if (listAll % 2 == 0) {
                listX2.add(listAll);
            }
            if (listAll % 3 == 0) {
                listX3.add(listAll);
            }
            if (listAll %2 != 0 && listAll %3 != 0) {
                listOther.add(listAll);
            }
        }

        printList(listX3);
        printList(listX2);
        printList(listOther);
    }

    public static void printList(List<Integer> list) {
            for (Integer print : list) {
                System.out.println(print);
            }
    }
}
