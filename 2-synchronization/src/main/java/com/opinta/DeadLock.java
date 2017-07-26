package com.opinta;

public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private static volatile int iteration1 = 0;
    private static volatile int iteration2 = 0;

    public static void main(String[] args) {
        final DeadLock dld = new DeadLock();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    dld.instanceMethod1();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ie) {}
                }
            }
        };
        Thread thdA = new Thread(r1);
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    dld.instanceMethod2();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ie) {}
                }
            }
        };
        Thread thdB = new Thread(r2);
        thdA.start();
        thdB.start();
    }

    public void instanceMethod1() {
        synchronized(lock1) {
            synchronized(lock2) {
                iteration1++;
                System.out.println("first thread in instanceMethod1: " + iteration1);
                // critical section guarded first by
                // lock1 and then by lock2
            }
        }
    }

    public void instanceMethod2() {
        synchronized(lock2) {
            synchronized(lock1) {
                iteration2++;
                System.out.println("second thread in instanceMethod2 " + iteration2);
                // critical section guarded first by
                // lock2 and then by lock1
            }
        }
    }
}
