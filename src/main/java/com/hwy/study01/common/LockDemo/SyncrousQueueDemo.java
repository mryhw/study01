package com.hwy.study01.common.LockDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description 同步队列
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        15:51 2019-10-10
 * @Version     v1
 *
 *      存一个取一个
 **/
public class SyncrousQueueDemo {

    public static void main(String[] args) throws Exception {

        BlockingQueue synchronousQueue = new SynchronousQueue();

        new Thread(() -> {
            try {
                synchronousQueue.put("a");
                System.out.println(Thread.currentThread().getName()+ " 添加 a");
                synchronousQueue.put("b");
                System.out.println(Thread.currentThread().getName()+ " 添加 b");
                synchronousQueue.put("c");
                System.out.println(Thread.currentThread().getName()+ " 添加 c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t1").start();

        new Thread(() -> {
            try {
                synchronousQueue.take();
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {  e.printStackTrace(); }
                synchronousQueue.take();
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {  e.printStackTrace(); }
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t2").start();
    }
}
