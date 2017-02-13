package com.shishpordenis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int quantityShips = 0;
    private static int oneDeck = 0;
    private static int twoDeck = 0;
    private static int threeDeck = 0;
    private static int fourDeck = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter you name: ");
        String userName = reader.readLine();
        System.out.println("Hello " + userName + "! Welcome to Battle Ship!");

        Ship ship1 = new Ship();
        ship1.CreateShip("qq", 12, 15);
    }
}
