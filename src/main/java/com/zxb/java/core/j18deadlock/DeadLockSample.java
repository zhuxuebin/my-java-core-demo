package com.zxb.java.core.j18deadlock;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/28
 */
public class DeadLockSample {

    private String lockA = new String();

    private String lockB = new String();

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception{

        DeadLockSample sample = new DeadLockSample();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                sample.methodA();
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                sample.methodB();
            }
        });

        executorService.execute(threadA);
        executorService.execute(threadB);
    }

    public void methodA(){
        synchronized (lockA){
            try {
                System.out.println(Thread.currentThread().getName()+" methodA");
                Thread.sleep(1000);
                synchronized (lockB){

                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void methodB(){
        synchronized (lockB){
            try {
                System.out.println(Thread.currentThread().getName()+" methodB");
                Thread.sleep(1000);
                synchronized (lockA){

                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
