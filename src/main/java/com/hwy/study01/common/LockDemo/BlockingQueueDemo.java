package com.hwy.study01.common.LockDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description 阻塞队列
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        14:07 2019-10-10
 * @Version     v1
 *
 * 队列
 * 阻塞队列
 **/
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception{

        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        /**
         * add()  remove() 是有边界的，
         *      add 超出之后会报 "java.lang.IllegalStateException: Queue full" 异常
         *      remove 超出之后会报 "java.util.NoSuchElementException" 异常
         * offer()  poll() 没有边界，会返回 boolean, peek():当前队列的第一个值
         *      true
         *      false
         *
         * put()  take() 阻塞 ，满了一直等，取不出来也一直等
         *
         * offer(obj, Long, TimeUtils)  poll(long, TimeUtils) 过时不候
         */
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("x"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

        System.out.println("==================================");
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

        System.out.println("================================");
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));

    }

}
