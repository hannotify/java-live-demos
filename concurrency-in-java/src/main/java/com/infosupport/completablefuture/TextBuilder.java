package com.infosupport.completablefuture;

import com.infosupport.threadtypes.ThreadTypes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class TextBuilder {
    public static void main(String[] args) throws InterruptedException {
        var fixedExecutor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> textBuilder = CompletableFuture
                .supplyAsync(() -> "Beste Hanno,")
                .thenApply(TextBuilder::genereerAanhef)
                .thenApplyAsync(brief -> String.format("%s%n%nGroeten, Hanno", brief), fixedExecutor)
                .thenApplyAsync(brief -> String.format("26 oktober 2023%n%n%s", brief), fixedExecutor);

        while (!textBuilder.isDone()) {
            System.out.println("CompletableFuture is not done.");
            Thread.sleep(1000);
        }

        try {
            var result = textBuilder.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            fixedExecutor.shutdown();
        }
    }

    private static String genereerAanhef(String aanhef) {
        var returnValue = String.format("%s%n%nHoe gaat het met je vandaag?", aanhef);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ThreadTypes.printThreadInfo(Thread.currentThread());

        return returnValue;
    }
}
