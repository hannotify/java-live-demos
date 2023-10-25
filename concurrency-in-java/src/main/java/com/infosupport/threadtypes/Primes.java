package com.infosupport.threadtypes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Primes {
    public static void calculatePrimes(long lowerLimit, long upperLimit) {
        final List<Long> primes = LongStream.rangeClosed(lowerLimit, upperLimit)
                .filter(n -> n % 2 != 0)
                .filter(Primes::isPrime)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(primes);

        System.out.println(System.nanoTime() + " / " + Thread.currentThread() + " is done.");
    }

    private static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) return true;

        for (long i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
