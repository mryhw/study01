package com.hwy.study01.common.LockDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多线程： 线程操作资源类
 * 缓存分三个方法
 *      1：读
 *      2：写
 *      3：清缓存
 * 用 ReentrantReadWriteLock 解决， 可重入的读写锁，提高并发效率
 */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    // 读写锁，读写分离
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 写
     * @param key
     * @param value
     */
    public void put(String key, Object value){

        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 正在写入：" + key);
            map.put(key, value);
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println(Thread.currentThread().getName()+" 写入完成");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * 读
     * @param key
     * @param value
     */
    public void get(String key, Object value){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 正在读取：" + key);
            map.put(key, value);
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println(Thread.currentThread().getName()+" 读取完成");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * 清空
     */
    public void clear() {
        map.clear();
    }
}

/**
 * 共享锁
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int ii = i;
            new Thread(() -> {
                cache.put(ii+"", ii+"1");
            },"t"+i).start();
        }

        for (int i = 0; i < 5; i++) {
            final int ii = i;
            new Thread(() -> {
                cache.get(ii+"", ii+"1");
            },"t"+i).start();
        }
        cache.clear();
    }
}
