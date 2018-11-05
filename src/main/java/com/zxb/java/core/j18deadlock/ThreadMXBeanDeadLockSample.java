package com.zxb.java.core.j18deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/28
 */
public class ThreadMXBeanDeadLockSample {

    private String lockA = new String();

    private String lockB = new String();

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception{
        ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
        Runnable dlCheck = new Runnable() {
            @Override
            public void run() {
                long[] threadIds = mbean.findDeadlockedThreads();
                if(threadIds != null){
                    ThreadInfo[] threadInfos = mbean.getThreadInfo(threadIds);
                    System.out.println("detect deadlock threads:");
                    for(ThreadInfo threadInfo : threadInfos){
                        System.out.println(threadInfo.getThreadName());
                    }
                }
            }
        };
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        //稍等5s,然后每隔10s扫描一次 这种方式会有一定的资源消耗，间隔时间要慎重选取
        scheduler.scheduleWithFixedDelay(dlCheck, 5L, 10L, TimeUnit.SECONDS);

        ThreadMXBeanDeadLockSample sample = new ThreadMXBeanDeadLockSample();

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
