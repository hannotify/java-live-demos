package com.infosupport.luchtalarm;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class LuchtalarmCompletionServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {;
        var testset = List.of(
                new Luchtalarm("Arnhem", 5),
                new Luchtalarm("Rotterdam", 10),
                new Luchtalarm("Hendrik-Ido-Ambacht", 15),
                new Luchtalarm("Waspik", 5),
                new Luchtalarm("Apeldoorn", 15),
                new Luchtalarm("'s Gravenhage", 15));

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            var completionService = new ExecutorCompletionService<String>(executorService);

            testset.forEach(l -> completionService.submit(l::testWithResult));

            Future<String> futureResult;
            do {
                futureResult = completionService.poll(60, TimeUnit.SECONDS);
                System.out.printf("Test is voltooid in %s.%n", futureResult.get());
            } while (futureResult != null);
            //completionService.s
        }
    }
}
