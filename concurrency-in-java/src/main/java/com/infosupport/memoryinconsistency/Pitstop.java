package com.infosupport.memoryinconsistency;

public class Pitstop {
    private static final Object lock = new Object();
    private static Boolean pitstop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread teamRadio = new Thread(() -> {
            while (!getPitstop()) {
            }

            System.out.println("[TEAM-RADIO] Box, box");

            while (getPitstop()) {
            }
            System.out.println("[TEAM-RADIO] Pitstop end, release clutch.");
        });

        teamRadio.start();

        Thread.sleep(1000);

        System.out.println("[TEAM] Pitstop time.");

        synchronized (lock) {
            pitstop = true;
        }

        Thread.sleep(2500);

        System.out.println("[TEAM] Pitstop end.");

        synchronized (lock) {
            pitstop = false;
        }
    }

    private static Boolean getPitstop() {
        synchronized (lock) {
            return pitstop;
        }
    }
}
