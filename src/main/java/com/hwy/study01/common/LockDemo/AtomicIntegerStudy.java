package com.hwy.study01.common.LockDemo;

import com.hwy.study01.common.vo.User;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description 原子整型，原子引用
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        15:21 2019-10-29
 * @Version     v1
 **/
public class AtomicIntegerStudy {

    static AtomicInteger int1 = new AtomicInteger(101);
    static AtomicStampedReference<Integer> int2 = new AtomicStampedReference<>(100 ,1);

    public static void main(String[] args) {
        AtomicIntegerStudy atomicIntegerStudy = new AtomicIntegerStudy();
//        atomicIntegerStudy.t1();
//        atomicIntegerStudy.t2();
//        atomicIntegerStudy.t3();
        for (int i = 0; i < 20; i++) {
            atomicIntegerStudy.t7();
        }
    }

    /**
     * set 线程不安全问题解决
     */
    Set set1 = new CopyOnWriteArraySet();
    public void t7() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                set1.add(UUID.randomUUID().toString().substring(0, 4));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":"+ set1);
            }
        }, "t1").start();
    }

    /**
     * set 线程不安全问题重现
     */
    Set set = new HashSet();
    public void t6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                set.add(UUID.randomUUID().toString().substring(0, 4));
                System.out.println(Thread.currentThread().getName() + ":"+ set);
            }
        }, "t1").start();
    }


    /**
     * 解决 list 的线程安全问题
     */
    List v1 = new Vector();
    List<String> list2 = Collections.synchronizedList(new ArrayList<>());
    List list3 = new CopyOnWriteArrayList();
    public void t5(){
        //解决 t4() 并发修改的问题

        // 方法 1 ：new Vector()
        new Thread(() -> {
            list2.add(UUID.randomUUID().toString().substring(0, 8));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":"+ list2);
        },"th2").start();

        // 方法2 ：Collections.synchronizedList(new ArrayList());
        new Thread(() -> {
            v1.add(UUID.randomUUID().toString().substring(0, 8));
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":"+ v1);
        },"th3").start();

        // 方法3：CopyOnWriteArrayList()

        new Thread(() -> {
            list3.add(UUID.randomUUID().toString().substring(0, 8));
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":"+ list3);
        },"th4").start();


    }

    /**
     * list 线程安全问题重现
     */
    List<String> list = new ArrayList<>();
    public void t4() {
        //集合类的不安全问题 java.util.ConcurrentModificationException 并发修改问题
        new Thread( new Runnable(){
            @Override
            public void run() {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }
        },"th1").start();

    }

    /**
     * ABA 问题 产生 以及 解决
     */
    public void t3() {
        // 以下是 ABA 问题的产生
        new Thread(() -> {
            System.out.println(int1.compareAndSet(101, 201)+ "======currValue="+int1.get()+ "=====name:"+ Thread.currentThread().getName());
            System.out.println(int1.compareAndSet(201, 101)+ "======currValue="+int1.get()+ "=====name:"+ Thread.currentThread().getName());

        }, "thread1").start();
        new Thread(() -> {
            TimeUnit.SECONDS.toSeconds(2);
            System.out.println(int1.compareAndSet(101, 2222)+ "======currValue="+int1.get()+ "=====name:"+ Thread.currentThread().getName());
        }, "thread2").start();


         // 以下是问题的解决
        TimeUnit.SECONDS.toSeconds(2);
        System.out.println("============解决问题===========");
        new Thread(() -> {
            boolean b = int2.compareAndSet(100, 101, int2.getStamp(), int2.getStamp() + 1);
            System.out.println(b+",stamp:" +int2.getStamp() + " currValue:" + int2.getReference());
            boolean b1 = int2.compareAndSet(101, 100, int2.getStamp(), int2.getStamp() + 1);
            System.out.println(b1+",stamp:" +int2.getStamp() + " currValue:" + int2.getReference());

        }, "t3").start();

        new Thread(() -> {
            int stamp = int2.getStamp();
            boolean b = int2.compareAndSet(100, 9999, 1, stamp + 1);
            System.out.println(b+",stamp:" +int2.getStamp() + " currValue:" + int2.getReference());
        }, "t3").start();

    }

    public void t2() {
        // ABA 问题(原子引用  AtomicReference)
        User z3 = new User("张三","11");
        User l4 = new User("李四","21");

        AtomicReference<User> atomicReference = new AtomicReference<>(z3);
        boolean b = atomicReference.compareAndSet(z3, l4);
        System.out.println(b+"===currUser="+atomicReference.get());
        boolean b1 = atomicReference.compareAndSet(z3, z3);
        System.out.println(b1 + "===currUser="+atomicReference.get());


    }

    public void t1() {
        // 原子整型 cas
        AtomicInteger num = new AtomicInteger(1);
        boolean b = num.compareAndSet(1, 2000);
        System.out.println(b + "---- currValue="+num.get());
        boolean b1 = num.compareAndSet(1, 3000);
        System.out.println(b1 + "---- currValue="+num.get());
    }


}
