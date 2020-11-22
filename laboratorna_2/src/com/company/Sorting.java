package com.company;

public class Sorting {
    private Sorting() {
    }

    private static int partition(Hamster[] arr, int low, int high, int numberOfHamstersToCompareBetween) {
        Hamster pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].getAllTotalOfFood(numberOfHamstersToCompareBetween) <
                    pivot.getAllTotalOfFood(numberOfHamstersToCompareBetween)) {
                i++;
                Hamster temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Hamster temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSort(Hamster[] arr, int low, int high, int numberOfHamstersToCompareBetween) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, numberOfHamstersToCompareBetween);

            quickSort(arr, low, pivotIndex - 1, numberOfHamstersToCompareBetween);
            quickSort(arr, pivotIndex + 1, high, numberOfHamstersToCompareBetween);
        }
    }
}
