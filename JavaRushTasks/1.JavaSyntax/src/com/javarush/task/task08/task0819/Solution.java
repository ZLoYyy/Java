package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        cats.remove(0);

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<>();

        Cat tom = new Cat();
        Cat jerry = new Cat();
        Cat alex = new Cat();

        cats.add(tom);
        cats.add(jerry);
        cats.add(alex);

        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.toString());
        }
    }

    public static class Cat {

    }
}
