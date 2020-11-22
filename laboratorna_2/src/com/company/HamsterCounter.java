package com.company;

public class HamsterCounter {
    private Hamster[] hamsters;
    private int numberOfHamstersUpperLimit = 0;
    private int numberOfHamstersLowerLimit = 0;

    private int dailyTotalOfFood = 0;
    private int allAvailableOfHamsters = 0;

    public void countMaxPossibleHamsters(String pathToFile) {
        hamsters = new Hamster[0];
        Reader reader = new Reader();
        reader.readFrom(pathToFile);
        dailyTotalOfFood = reader.getDailyTotalOfFood();
        numberOfHamstersUpperLimit = reader.getQuantityOfHamstersUpperLimit();

        evaluateAll();

        Writer writer = new Writer();
        writer.writeToFile(allAvailableOfHamsters);
    }


    private void evaluateAll() {
        while (true) {
            int currentLastElementIndex = (numberOfHamstersLowerLimit + numberOfHamstersUpperLimit) / 2;
            Sorting.quickSort(hamsters, 0, hamsters.length - 1, currentLastElementIndex);

            double sumOfElementsOfArray = sumOfElementsOfArray(hamsters, currentLastElementIndex);

            if (sumOfElementsOfArray - dailyTotalOfFood > hamsters[currentLastElementIndex].getAllTotalOfFood(currentLastElementIndex)
                    || numberOfHamstersLowerLimit == currentLastElementIndex) {
                allAvailableOfHamsters = currentLastElementIndex;
                break;
            }
            if (sumOfElementsOfArray > dailyTotalOfFood) {
                numberOfHamstersUpperLimit = currentLastElementIndex;
            } else {
                numberOfHamstersLowerLimit = currentLastElementIndex;
            }

        }
    }

    private int sumOfElementsOfArray(Hamster[] hamsters, int end) {
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += hamsters[i].getAllTotalOfFood((numberOfHamstersLowerLimit + numberOfHamstersUpperLimit) / 2);
        }
        return sum;
    }
}
