package com.opinta;

public class ThreadStopping_2_safeMessy {
    public static void main(String[] args) {
        class StoppableThread extends Thread {
            private boolean stopped; // defaults to false
            @Override
            public void run() {
                // this is thread safe, but the code is messy
                // to overpass this we can use keyword volatile and remove synchronize blocks
                // see the class ThreadStopping_3_safeSimple_volatile
                boolean _stopped = false;
                while (!_stopped) {
                    synchronized(this) {
                        _stopped = stopped;
                    }
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
