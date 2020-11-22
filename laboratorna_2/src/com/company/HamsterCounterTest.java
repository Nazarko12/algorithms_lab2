package com.company;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HamsterCounterTest {

    private Scanner scanner;

    @BeforeEach
    public void initializeScanner(){
        try {
            scanner = new Scanner(new File("C:/projects/hamster.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testWithExampleFirst() {
        testMethod("C:/projects/hamster.in", "3");
    }

    @Test
    void testWithExampleSecond() {
        testMethod("C:/projects/hamster2.in", "2");
    }

    @Test
    void testWithExampleThird() {
        testMethod("C:/projects/hamster3.in", "1");
    }

    private void testMethod(String pathToFile, String expected) {
        HamsterCounter hamsterCounter = new HamsterCounter();
        hamsterCounter.countMaxPossibleHamsters(pathToFile);
        assertEquals(expected, scanner.nextLine());
    }

}
