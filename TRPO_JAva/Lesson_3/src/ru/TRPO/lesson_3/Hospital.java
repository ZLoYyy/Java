package ru.TRPO.lesson_3;

import java.util.ArrayList;

/**
 * Created by ((ZLoY)) on 06.11.2016.
 */
public class Hospital {
    private ArrayList<Doctor> doctors;
    private int i = 0;

    public void addDoctor(Doctor doctor) {
        doctors = new ArrayList<>();
        doctors.add(doctor);
        System.out.println(doctors.get(i));
    }

    public void medExam(Patient patient) {
        for(Doctor x: doctors) {
        }
    }

}
