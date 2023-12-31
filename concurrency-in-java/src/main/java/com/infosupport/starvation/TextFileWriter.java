package com.infosupport.starvation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TextFileWriter {

    public synchronized void write() {
        var threadName = Thread.currentThread().getName();
        String fileName = "concurrency-in-java/src/main/resources/" + threadName + ".txt";

        try {
            Files.write(Path.of(fileName), String.format("%s wrote this message.", threadName).getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println(threadName + " is busy writing files...");
        }
    }
}
