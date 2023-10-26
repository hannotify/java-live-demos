package com.infosupport.forkjoin;

import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try (ForkJoinPool pool = new ForkJoinPool()) {
            DirectoryProcessor developer = new DirectoryProcessor(
                    new File("/Users/hanno/Developer"),
                    ".class");
            DirectoryProcessor photos = new DirectoryProcessor(
                    new File("/Users/hanno/cloud-storage/Stack"),
                    ".mp4");

            pool.execute(developer);
            pool.execute(photos);

            do {
                System.out.format("******************************************%n");
                System.out.format("Main: Parallelism: %d%n", pool.getParallelism());
                System.out.format("Main: Active Threads: %d%n", pool.getActiveThreadCount());
                System.out.format("Main: Queued Task Count: %d%n", pool.getQueuedTaskCount());
                System.out.format("Main: Steal Count: %d%n", pool.getStealCount());
                System.out.format("******************************************%n");

                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (!developer.isDone() && !photos.isDone());

            System.out.printf("developer: %d files found.%n", developer.join().size());
            System.out.printf("photos: %d files found.%n", photos.join().size());
        }
    }
}
