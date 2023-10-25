package com.infosupport.luchtalarm;

import java.util.List;

public class LuchtalarmThreadTest {
    public static void main(String[] args) {
        var testInWaspik = new Luchtalarm("Waspik", 5);
        var testInApeldoorn = new Luchtalarm("Apeldoorn", 15);

        var testset = List.of(
                new Luchtalarm("Arnhem", 15),
                new Luchtalarm("Rotterdam", 10),
                new Luchtalarm("Hendrik-Ido-Ambacht", 20),
                new Luchtalarm("'s Gravenhage", 25));

//        testset.forEach(l -> new Thread(l::test).start());

        var threadWaspik = new Thread(testInWaspik::test);
        var threadApeldoorn = new Thread(testInApeldoorn::test);

        threadWaspik.start();

        try {
            threadWaspik.join(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        threadApeldoorn.start();
    }
}
