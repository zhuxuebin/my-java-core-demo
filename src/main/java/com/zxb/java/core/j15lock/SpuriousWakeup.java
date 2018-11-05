package com.zxb.java.core.j15lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/27
 */
public class SpuriousWakeup {

    private Lock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();

    private Condition notFull = lock.newCondition();

    private Queue queue = new LinkedList();

    private boolean flag = true;

    public static void main(String[] args) {
        SpuriousWakeup spuriousWakeup = new SpuriousWakeup();

        //waiting thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                spuriousWakeup.waitMethod();
            }
        }).start();

        //signal thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                spuriousWakeup.signalMethod();
            }
        }).start();
    }

    public void waitMethod(){
        synchronized (this) {
            try {
                //while换成if就是spurious wake, 一旦其他线程调用notify,则直接往下执行，因为不会再去判断if条件了，可能导致预料不到的结果
                while(flag) {
                    wait();
                }
//                if(flag){
//                    wait();
//                }

                System.out.println("notify waitMethod");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void signalMethod(){
        synchronized (this) {
            try {
                if (flag) {
//                    flag = false;
                    notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
