package com.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
// 思路是，可以使用等待-通知机制来实现，
// 设置一把锁lock，两个boolean变量表示first函数、second函数是否执行
// 当first方法执行时，将firstFinished设置为true，并调用lock.notifyAll()
// 在second中，先要判断第一个方法是否执行，如果没有则进入等待状态，否则执行打印代码，并将secondFinished设置为true，并调用lock.notifyAll()
// 在third中，先要判断第一个方法是否执行，如果没有则进入等待状态，否则执行打印代码
public class Num1114_PrintinOrder {


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


}

