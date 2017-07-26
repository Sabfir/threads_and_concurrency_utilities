package com.opinta;

public class ThreadStopping_1_unsafe {
    public static void main(String[] args) {
        class StoppableThread extends Thread {
            private boolean stopped; // defaults to false
            @Override
            public void run() {
                synchronized(this) {
                    // this is not thread safe
                    // in the while loop stopped field will not been read from the cash
                    // because it has read the value from the memory when entering the synchronized block
                    // and will write to the memory while  exiting
                    // to overpass this limit we should move synchronize reading stopped field to the loop
                    // see the implementation in the ThreadStopping_2_safeMessy
                    while(!stopped)
                        System.out.println("running");
                }
            }
            synchronized void stopThread() {
                stopped = true;
            }
        }
        StoppableThread thd = new StoppableThread();
        thd.start();
        try {
            Thread.sleep(1000); // sleep for 1 second
        }
        catch (InterruptedException ie) {}
        thd.stopThread();
    }
}
