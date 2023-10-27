package com.infosupport.maxnumberofthreads;

public class MaxNumberOfThreads {
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            Thread.ofVirtual().start(() -> {
                count++;

                System.out.println("New thread #" + count);

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            });
        }

    }
}
