package com.zxb.java.core.j18deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 * lock.tryLock()试着获取锁，获取到返回true, 否则返回false，根据这个做下一步
 * lock.tryLock(time,timeUnit), 指定时间内获取锁，获取到返回true, 否则返回false
 * @author 01368080
 * @date 2018/9/29
 */
public class TryLockSample {

    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        TryLockSample sample = new TryLockSample();
        //1. 同一个线程，可lock是可重入锁
//        sample.lockMethod();
//        sample.tryLockMethod();

        //2. 不同线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                sample.lockMethod();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sample.tryLockTimeMethod();
            }
        }).start();
    }

    public void lockMethod(){
        lock.lock();
        try{
            Thread.sleep(1000);
            System.out.println("in lockMethod");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void tryLockMethod(){
        if(lock.tryLock()){
            System.out.println("in tryLockMethod");
        }
    }

    public void tryLockTimeMethod(){
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                System.out.println("in tryLockMethod");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
