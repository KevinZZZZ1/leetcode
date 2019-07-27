package com.leetcode.concurrency;

import java.util.function.IntConsumer;

// 给定一个整数n，期望输出010203...
// Input: n = 5
// Output: "0102030405"
// zero()方法会打印0，even()方法会打印偶数，odd()方法会打印奇数
// 将分别使用三个线程调用zero(),even(),odd()期望得到上面所示输出
public class Num1116PrintZeroEvenOdd {

    private int n;



    public Num1116PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    private final Object lock = new Object(); // 互斥锁
    private boolean canPrintZero = true; // 能打印0
    private boolean canPrintEven = false; // 能打印偶数
    private boolean canPrintOdd = false; // 能打印奇数

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (lock){
                while (!canPrintZero){
                    lock.wait();
                }

                printNumber.accept(0);
                canPrintZero = false;
                if(i%2==0) {
                    canPrintEven = true;
                    canPrintOdd = false;
                }
                else {
                    canPrintOdd = true;
                    canPrintEven = false;
                }
                lock.notifyAll();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i+=2){
            synchronized (lock){
                while (!canPrintEven){
                    lock.wait();
                }

                printNumber.accept(i);
                canPrintEven = false;
                canPrintOdd = false;
                canPrintZero = true;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n ; i+=2) {
            synchronized (lock){
                while (!canPrintOdd){
                    lock.wait();
                }

                printNumber.accept(i);
                canPrintOdd = false;
                canPrintEven = false;
                canPrintZero = true;
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) {

        Num1116PrintZeroEvenOdd n = new Num1116PrintZeroEvenOdd(5);

        IntConsumer c = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.zero(c);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.even(c);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.odd(c);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
