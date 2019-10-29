package com.hwy.study01.common.LockDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 多线程的方法 ：Runnable
 */
class MyThread implements Runnable{

    @Override
    public void run() {
    }
}

/**
 * 多线程方法： Callable
 */
class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 100;
    }
}


public class CallableDemo {

    public static void main(String[] args) throws Exception{
        Integer result = 0;
        for (int i = 0; i < 10; i++) {
            FutureTask<Integer> integerFutureTask = new FutureTask<>(new MyThread2());
            Thread thread = new Thread(integerFutureTask);
            thread.start();
            result += integerFutureTask.get();
            System.out.println(result);
        }
    }
}
