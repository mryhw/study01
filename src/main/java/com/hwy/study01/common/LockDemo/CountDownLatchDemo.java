package com.hwy.study01.common.LockDemo;

import java.util.concurrent.*;

/**
 * CountDownLatch 使用（做减法）
 */
public class CountDownLatchDemo {

    public static void main(String[] args){
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        countDownLatchDemo.m3();
    }

    /**
     * 信号量
     */
    public void m3() {
        // 默认是非公平锁
        Semaphore semaphore = new Semaphore(3); // 模拟3个车位
        //模拟 6 个车
        for (int i = 0; i < 7; i++) {
            final  int ii = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+ " 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+ " 离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },ii+"").start();
        }
    }

    /**
     * CyclicBarrier 使用 做加法（回环栅栏）
     */
    public void m2(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()-> {
            System.out.println("收集完成，可以正式开始。。。。");
        });
        for (int i = 0; i < 7; i++) {
            final int ii = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+ " 收集到第" + ii + "个");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },ii+"").start();
        }
    }

    /**
     * CountDownLatch 做减法 (计数器)
     * @throws Exception
     */
    public void m1() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 100; i++) {
            final int ii = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+" 离开");
                countDownLatch.countDown();
            }, "t"+ ii).start();
        }
        countDownLatch.await();
        System.out.println("全部完成");
    }
}
