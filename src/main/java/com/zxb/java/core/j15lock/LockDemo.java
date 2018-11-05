package com.zxb.java.core.j15lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 * @author 01368080
 * @date 2018/9/25
 */
public class LockDemo {

    private Lock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();

    private Condition notFull = lock.newCondition();

    private Queue queue = new LinkedList();

    public static void main(String[] args) throws Exception{
        LockDemo lockDemo = new LockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //在同一个线程中，lock锁是可重入的
                //调用condition.await/signal方法同样是要先获取锁的监视器对象，不然无法使用（类似于wait,signal）
                for (int i = 0; i < 6; i++) {
                    lockDemo.enqueue(i);
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                lockDemo.dequeue();
            }
        }).start();
        Thread.sleep(1000);
    }

    //进栈
    public void enqueue(int i) {
        lock.lock();
        try {
            System.out.println("before enqueue "+i);
            while (queue.size() >= 5) {
                System.out.println("while enqueue "+i);
                notFull.await();
            }
            queue.add(i);
            System.out.println("enqueue "+i);
            notEmpty.signal();
        } catch (Exception e) {
            //一定不能直接吃掉Exception
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //出栈
    public void dequeue() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            queue.poll();
            System.out.println("dequeue "+queue.size());
            notFull.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
