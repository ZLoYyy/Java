package ru.TRPO.lesson_3;

/**
 * Created by ((ZLoY)) on 06.11.2016.
 */
class ENT implements Doctor {
    @Override
    public void take(Patient patient) {
        System.out.println("ЛОР принимает пациента");
        patient = new Patient();
        patient.getEar();
        patient.getNose();
        patient.getThroat();
    }
}
