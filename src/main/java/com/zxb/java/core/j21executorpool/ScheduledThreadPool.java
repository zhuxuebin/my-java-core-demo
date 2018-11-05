package com.zxb.java.core.j21executorpool;

import java.util.Date;
import java.util.concurrent.*;

/**
 * 描述：
 *  https://www.journaldev.com/2340/java-scheduler-scheduledexecutorservice-scheduledthreadpoolexecutor-example
 * @author 01368080
 * @date 2018/10/18
 */
public class ScheduledThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);


        /*//schedule to run after sometime
        System.out.println("Current Time = "+new Date());
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("do heavy processing");
            // schedule task to execute at fixed rate 每个任务都是立刻执行，之后每隔十秒(相对于执行开始时间)再执行一轮，如此往复
            scheduledThreadPool.scheduleAtFixedRate(worker, 0, 10,
                    TimeUnit.SECONDS);
        }*/

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("do heavy processing");
            //每个任务立刻执行，之后每隔1s（相对于当前任务的执行结束时间）再执行一轮，如此往复
            scheduledThreadPool.scheduleWithFixedDelay(worker, 0, 2,
                    TimeUnit.SECONDS);
        }

        //add some delay to let some threads spawn by scheduler
        Thread.sleep(30000);

        scheduledThreadPool.shutdown();
        while(!scheduledThreadPool.isTerminated()){
            //wait for all tasks to finish
        }
        System.out.println("Finished all threads");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(1);
    }

}
