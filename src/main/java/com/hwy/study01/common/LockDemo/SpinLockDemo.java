package com.hwy.study01.common.LockDemo;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 不会立即阻塞，而是采用循环的方式获取锁，减少线程切换的消耗，缺点是循环会消耗CPU
 */
public class SpinLockDemo {

    // 默认是 null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock () {
        while (!atomicReference.compareAndSet(null, Thread.currentThread())){
        }
    }

    public void myUnlock(){
        atomicReference.compareAndSet(Thread.currentThread(), null);
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            System.out.println(Thread.currentThread().getName()+ "======== lock");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
            System.out.println(Thread.currentThread().getName()+ "======== unlock");
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+ "======== 2222222");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDemo.myLock();
            System.out.println(Thread.currentThread().getName()+ "======== lock");
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+ "======== 111111111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
            System.out.println(Thread.currentThread().getName()+ "======== unlock");
        }, "t2").start();



    }



}
