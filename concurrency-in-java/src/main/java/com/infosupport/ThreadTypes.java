package com.infosupport;

public class ThreadTypes {
    public static void main(String[] args) {
        printInfo(Thread.currentThread());
        //Thread.getAllStackTraces().keySet().forEach(ThreadTypes::printInfo);

        Thread primes = new Thread(() -> Primes.calculatePrimes(1, 100_001));
        primes.setName("Calculate-Primes");
        primes.setPriority(Thread.MAX_PRIORITY);

        Thread primesDaemon = new Thread(() -> Primes.calculatePrimes(1, 10_000_001));
        primesDaemon.setName("Calculate-Primes-Daemon");
        primesDaemon.setDaemon(true);
        primesDaemon.setPriority(Thread.MIN_PRIORITY);

        primes.start();
        primesDaemon.start();

        printInfo(primes);
        printInfo(primesDaemon);
    }

    private static void printInfo(Thread thread) {
        System.out.print(thread);
        System.out.println(thread.isDaemon() ? " (daemon thread)" : " (user thread)");
        System.out.format("Total # of threads: %d%n", Thread.activeCount());
    }
}
