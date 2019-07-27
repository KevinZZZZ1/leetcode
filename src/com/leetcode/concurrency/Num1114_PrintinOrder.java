package com.leetcode.concurrency;


// 下面类Foo的实例foo会被分配给三个不同的线程，线程A会调用first函数，线程B会调用second函数，线程C会调用third函数，设计一种机制保证second函数在first函数之后执行，third函数在second函数之后执行
public class Num1114_PrintinOrder {

    // 思路是，可以使用等待-通知机制来实现，
    // 设置一把锁lock，两个boolean变量表示first函数、second函数是否执行
    // 当first方法执行时，将firstFinished设置为true，并调用lock.notifyAll()
    // 在second中，先要判断第一个方法是否执行，如果没有则进入等待状态，否则执行打印代码，并将secondFinished设置为true，并调用lock.notifyAll()
    // 在third中，先要判断第一个方法是否执行，如果没有则进入等待状态，否则执行打印代码
    private Object lock = new Object();
    private boolean firstFinished = false;
    private boolean secondFinished = false;
    public Num1114_PrintinOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized(lock){
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(lock){
            while(!firstFinished){
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized(lock) {
            while(!secondFinished){
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        }

    }


    public static void main(String[] args) {
        Num1114_PrintinOrder n = new Num1114_PrintinOrder();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        };

        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        };


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    n.first(r1);
                }catch (InterruptedException e){

                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.second(r2);
                }catch (InterruptedException e){

                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.third(r3);
                }catch (InterruptedException e){

                }
            }
        });


        t1.start();
        t2.start();
        t3.start();
    }


}

