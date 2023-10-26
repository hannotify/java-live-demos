package com.infosupport.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BestPriceFinder {
    public static void main(String[] args) {
        var amazonPrice = CompletableFuture.supplyAsync(supplyPrice("AmazonAmazon", 1, 8));
        var coolbluePrice = CompletableFuture.supplyAsync(supplyPrice("Coolblue", 3, 11));
        var bolComPrice = CompletableFuture.supplyAsync(supplyPrice("bol.com" , 2, 13));

        try {
            StorePrice bestStorePriceOverall = amazonPrice
                    .thenCombine(bolComPrice, BestPriceFinder::storeWithLowestPrice)
                    .thenCombine(coolbluePrice, BestPriceFinder::storeWithLowestPrice)
                    .get();
            System.out.printf("Best price is '%d' at the '%s' store.", bestStorePriceOverall.price(), bestStorePriceOverall.store());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static Supplier<StorePrice> supplyPrice(String store, int min, int max) {
        return () -> {
            int randomPrice = ThreadLocalRandom.current().nextInt(min, max + 1);

            System.out.printf("Retrieving price at %s...%n", store);

            try {
                TimeUnit.SECONDS.sleep(store.length());
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted, canceling price retrieval at " + store, e);
            }

            System.out.printf("Price at %s is %d.%n", store, randomPrice);
            return new StorePrice(store, randomPrice);
        };
    }

    private static StorePrice storeWithLowestPrice(StorePrice a, StorePrice b) {
        return Stream.of(a, b)
                .sorted()
                .findFirst()
                .get();
    }

    private record StorePrice(String store, int price) implements Comparable<StorePrice> {
        @Override
        public int compareTo(StorePrice o) {
            return Integer.compare(price, o.price);
        }
    }
}
