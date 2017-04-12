package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "a");
        map.put("23", "c");
        map.put("4", "d");
        map.put("6", "b");
        map.put("7", "a");
        map.put("44", "c");
        map.put("11", "g");
        map.put("34", "e");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int result = 0;

        for(Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) {
                result++;
            }
        }
        return result;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int result = 0;

        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName)) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
