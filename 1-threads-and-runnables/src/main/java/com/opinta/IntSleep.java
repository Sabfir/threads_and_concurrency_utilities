package com.opinta;

import static java.lang.String.format;

public class IntSleep {

    public void execute() {
        Runnable runnable = () -> {
            while (true) {
                System.out.println("Hello");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    outputInterruptedMessage();
                    break;
                }
            }
        };

        Thread thread = new Thread(runnable, "Child");
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            outputInterruptedMessage();
        }
        thread.interrupt();
    }

    private void outputInterruptedMessage() {
        System.out.println(format("Interrupted! %s", Thread.currentThread().getName()));
    }
}
