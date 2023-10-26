package com.infosupport.luchtalarm;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LuchtalarmExecutorServiceInvokeAllTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {;
        var testset = List.of(
                new Luchtalarm("Arnhem", 5),
                new Luchtalarm("Rotterdam", 10),
                new Luchtalarm("Hendrik-Ido-Ambacht", 15),
                new Luchtalarm("Waspik", 5),
                new Luchtalarm("Apeldoorn", 15),
                new Luchtalarm("'s Gravenhage", 15));

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            var futures = executorService.invokeAll(
                    testset.stream()
                            .map(l -> (Callable<String>) l::testWithResult)
                            .toList());

            for (var future : futures) {
                while (!future.isDone()) {
                    System.out.printf("Test nog bezig...%n");
                    Thread.sleep(2000);
                }

                System.out.printf("Test is voltooid in %s.%n", future.get());
            }
        }
    }
}
