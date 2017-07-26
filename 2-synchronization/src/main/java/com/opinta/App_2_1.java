package com.opinta;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;

public class App_2_1 {
    private static BigDecimal result;

    public static void main(String[] args) {
        Runnable r = () -> result = computePi(50000);
        Thread t = new Thread(r);
        t.start();
        try {
            t.join();
        }
        catch (InterruptedException ie) {}
        System.out.println(result);
    }

    private static BigDecimal computePi(int i) {
        return TEN;
    }
}
