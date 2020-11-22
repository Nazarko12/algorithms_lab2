package com.company;

import java.io.File;
import java.io.FileWriter;

public class Writer {
    public void writeToFile(int maxNumberOfHamsters) {
        try (FileWriter fileWriter = new FileWriter(new File("C:/projects/hamster.out"))) {
            fileWriter.write("" + maxNumberOfHamsters);
            fileWriter.flush();
        } catch (Exception ignored) {
        }
    }
}
