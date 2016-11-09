package ru.TRPO.lesson_3;

public class Application {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.addDoctor();
        hospital.addDoctor("Oculist");

        hospital.medExam();


    }
}
