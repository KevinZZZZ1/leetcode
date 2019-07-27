package com.leetcode.concurrency;

// 给定一个整数n，线程A调用foo()打印"foo"，线程B调用bar()打印"bar",使得字符串"foobar"出现n次
// Input: n = 2
// Output: "foobarfoobar"
// Explanation: "foobar" is being output 2 times.
public class Num1115_PrintFooBarAlternately {

    private int n;

    public Num1115_PrintFooBarAlternately(int n) {
        this.n = n;
    }

    private final Object lock = new Object();
    private boolean canPrintFoo = true;
    private boolean canPrintBar = false;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {

                while (!canPrintFoo){
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                canPrintFoo = false;
                canPrintBar = true;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                while (!canPrintBar){
                    lock.wait();
                }

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                canPrintBar = false;
                canPrintFoo = true;
                lock.notifyAll();
            }

        }
    }


    public static void main(String[] args) {

        Num1115_PrintFooBarAlternately n =new Num1115_PrintFooBarAlternately(5);

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        };

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.foo(r1);
                }catch (InterruptedException e){

                }
            }
        });

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.bar(r2);
                }catch (InterruptedException e){

                }
            }
        });


        t1.start();
        t2.start();

    }


}
