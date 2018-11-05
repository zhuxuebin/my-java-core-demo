package com.zxb.java.core.j21executorpool;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/18
 */
public class WorkerThread implements Runnable{

    private String command;

    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End. Time = "+new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
