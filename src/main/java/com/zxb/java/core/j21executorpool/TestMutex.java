package com.zxb.java.core.j21executorpool;

import java.util.concurrent.CyclicBarrier;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/23
 */
public class TestMutex {

    private static CyclicBarrier barrier = new CyclicBarrier(31);

    private static int a = 0;

    private static Mutex mutex = new Mutex();

    public static void main(String[] args) throws Exception {
        for(int i=0;i<30;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        a++;
                    }
                    try {
                        barrier.await();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        barrier.await();
        System.out.println("加锁前a="+a);

        barrier.reset();
        a = 0;
        for(int i=0;i<30;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        mutex.lock();
                        a++;
                        mutex.unlock();
                    }
                    try{
                        barrier.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        barrier.await();
        System.out.println("加锁后a="+a);

    }
}
