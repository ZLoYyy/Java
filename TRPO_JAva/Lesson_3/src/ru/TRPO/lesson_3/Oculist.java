package ru.TRPO.lesson_3;

/**
 * Created by ((ZLoY)) on 06.11.2016.
 */
class Oculist implements Doctor {
    @Override
    public void take(Patient patient) {
        System.out.println("Окулист принимает пациента");
        patient = new Patient();
        patient.getEye();
    }
}
