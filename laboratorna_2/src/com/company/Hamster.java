package com.company;

class Hamster {
    public int id;
    public int dailyFoodOfGood;
    public int greedyOfHamsters;

    public Hamster(int id, int dailyFoodOfGood, int greedyOfHamsters) {
        this.id = id;
        this.dailyFoodOfGood= dailyFoodOfGood;
        this.greedyOfHamsters = greedyOfHamsters;
    }

    public int getAllTotalOfFood(int numberOfHamsters) {
        return dailyFoodOfGood + greedyOfHamsters * (numberOfHamsters - 1);
    }

}
