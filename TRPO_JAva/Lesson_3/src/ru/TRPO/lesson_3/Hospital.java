package ru.TRPO.lesson_3;

import java.util.ArrayList;

/**
 * Created by ((ZLoY)) on 06.11.2016.
 */
public class Hospital {


    public void addDoctor(String doctor) {
        int num = 2;
        ArrayList<String> doctors = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            doctors.add(i, doctor);
        }
    }

    public void medExam(String patient) {

    }

}
