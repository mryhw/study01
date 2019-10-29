package com.hwy.study01.common.LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockDemo {
    /**
     * 可重入锁/（递归锁）（默认是非公平锁）
     * 公平锁：先来后到
     * 非公平锁：可能由县级翻转或者饥饿现象（后来的先获得锁）
     * synchronized 天生的可重入锁
     * 定义： 线程可进入任何一个已经拥有锁的同步着的代码块
     */
    // 非公平锁
    Lock lock = new ReentrantLock();
    // 公平锁
    Lock lock1 = new ReentrantLock(true);

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getId()+"=================== : m1");
        this.m2 ();
    }
    public synchronized void m2() {
        System.out.println(Thread.currentThread().getId()+"=================== : m2");
    }
    public void m3() {
        lock.lock();
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId()+"=================== : m3");
            this.m4();
        } finally {
            lock.unlock();
        }
    }
    public void m4() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId()+"=================== : m4");
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {

        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        new Thread(() -> {
            reentrantLockDemo.m1();
        }, "t1").start();

        new Thread(() -> {
            reentrantLockDemo.m3();
        }, "t3").start();

    }


}
