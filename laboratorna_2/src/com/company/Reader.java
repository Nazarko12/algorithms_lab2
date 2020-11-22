package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

    private int dailyTotalOfFood;
    private int quantityOfHamstersUpperLimit;

    public Hamster[] readFrom(String pathToFile) {
        Hamster[] hamsters;
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            int quantityOfHamstersInShop = 0;
            dailyTotalOfFood = Integer.parseInt(scanner.nextLine());
            quantityOfHamstersInShop = Integer.parseInt(scanner.nextLine());
            hamsters = new Hamster[ quantityOfHamstersInShop];
            quantityOfHamstersUpperLimit = quantityOfHamstersInShop;
            for (int i = 0; i <  quantityOfHamstersInShop; i++) {
                String s = scanner.nextLine();
                String[] a = s.split(" ");
                int dailySth = Integer.parseInt(a[0]);
                int greedyOfHamsters = Integer.parseInt(a[1]);
                hamsters[i] = new Hamster(i + 1, dailySth, greedyOfHamsters);

            }

        } catch (IOException e) {
            e.printStackTrace();
            hamsters = new Hamster[]{new Hamster(1, 1, 2), new Hamster(2, 2, 2)};
        }
        return hamsters;
    }

    public int getDailyTotalOfFood() {
        return dailyTotalOfFood;
    }

    public int getQuantityOfHamstersUpperLimit() {
        return quantityOfHamstersUpperLimit;
    }
}
