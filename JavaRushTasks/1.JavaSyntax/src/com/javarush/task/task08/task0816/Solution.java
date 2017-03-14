package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("1", new Date("JUNE 5 1970"));
        map.put("12", new Date("JUNE 6 1980"));
        map.put("123", new Date("MAY 4 1990"));
        map.put("1234", new Date("APRIL 15 1980"));
        map.put("12345", new Date("JUNE 25 1980"));
        map.put("123456", new Date("APRIL 1 1970"));
        map.put("1234567", new Date("JUNE 7 1980"));
        map.put("12345678", new Date("APRIL 19 1960"));
        map.put("123456789", new Date("JUNE 30 1989"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            int month = iterator.next().getValue().getMonth()+1;
            if (month > 5 && month < 9) {
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {
    }
}
