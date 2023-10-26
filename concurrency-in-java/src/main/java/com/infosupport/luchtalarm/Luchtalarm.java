package com.infosupport.luchtalarm;

import java.awt.*;
import java.util.stream.IntStream;

public record Luchtalarm(String plaats, int testduurInSeconden) {
    public void test() {
        IntStream.rangeClosed(1, testduurInSeconden)
                .forEach(huidigeSeconde -> {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.format("#luchtalarm! Test in %s, seconde %d van %d%n",
                            plaats, huidigeSeconde, testduurInSeconden);
//                    System.out.println("Active thread count: " + Thread.activeCount());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public String testWithResult() {
        test();

        return plaats;
    }
}
