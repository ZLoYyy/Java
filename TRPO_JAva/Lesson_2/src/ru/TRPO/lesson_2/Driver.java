package ru.TRPO.lesson_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String extension;
        int nExtension = 1;
        int i = 0;
        Car car = new BMW("red");

        while (nExtension == 1) {

            if (i >= 1) {
                System.out.println("Do you want continue?(1\\0)");
                extension = reader.readLine();
                nExtension = Integer.parseInt(extension);
            }

            if (nExtension == 0) {
                System.out.println("end");
                break;
            } else if (nExtension != 1) {
                System.out.println("Error");
                break;
            }

            System.out.println("1 - Started");
            System.out.println("2 - Stoped");
            System.out.println("3 - Report");
            System.out.print("Enter the action: ");

            String position = reader.readLine();
            int nPosition = Integer.parseInt(position);

            switch (nPosition) {
                case 1:
                    car.start();
                    break;
                case 2:
                    car.stop();
                    break;
                case 3:
                    car.report();
                    break;
                default:
                    System.out.println("Error!!!");
            }

            i++;
        }
    }
}
