package com.leetcode.concurrency;

public class Num1117_BuildingH2O {

    public Num1117_BuildingH2O() {

    }

    private final Object lock = new Object();
    private int hCount = 0;


    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (lock){
            while (hCount==2){
                lock.wait();
            }
            hCount++;
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            lock.notifyAll();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lock){
            while (hCount!=2){
                lock.wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            hCount=0;
            lock.notifyAll();
        }
    }


    public static void main(String[] args) {
        Num1117_BuildingH2O n = new Num1117_BuildingH2O();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("H");
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("O");
            }
        };

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.hydrogen(r1);
                }catch (InterruptedException e){

                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.oxygen(r2);
                }catch (InterruptedException e){

                }
            }
        });

        t1.start();
        t2.start();
    }

}
