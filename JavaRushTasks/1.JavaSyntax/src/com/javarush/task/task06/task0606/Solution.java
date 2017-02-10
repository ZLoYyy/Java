package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.StringTokenizer;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNumber = reader.readLine();
        char[] chars = sNumber.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Integer.parseInt(String.valueOf(chars[i])) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even + " " + "Odd: " + odd);
    }
}