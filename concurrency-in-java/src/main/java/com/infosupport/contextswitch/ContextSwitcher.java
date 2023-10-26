package com.infosupport.contextswitch;

public class ContextSwitcher {
    private final Object lock = new Object();
    private int taskLength = 5000;
    private long startTime;
    private long endTime;

    public void switchContexts() {
        synchronized(lock){
            new Thread(() -> {
                synchronized(lock){
                    startTime = System.currentTimeMillis();
                    try {
                        Thread.sleep(taskLength);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.notify();
                }
            }).start();
            try {
                lock.wait();
                endTime = System.currentTimeMillis();
            }
            catch( InterruptedException e ){
                // do something if interrupted
            }
        }
        System.out.println("Context Switch Time elapsed: " + (endTime - startTime - taskLength));
    }
}
