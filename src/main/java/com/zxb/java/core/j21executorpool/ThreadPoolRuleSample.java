package com.zxb.java.core.j21executorpool;

import java.util.concurrent.*;

/**
 * 描述：
 *  https://blog.csdn.net/qq_25806863/article/details/71126867
 * @author 01368080
 * @date 2018/10/18
 */
public class ThreadPoolRuleSample {

    public static void main(String[] args) throws Exception{
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName()+" run");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,6,5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));

//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
//        System.out.println("---先开三个---");
//        System.out.println("核心线程数" + executor.getCorePoolSize());
//        System.out.println("线程池数" + executor.getPoolSize());
//        System.out.println("队列任务数" + executor.getQueue().size());
//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
//        System.out.println("---再开三个---");
//        System.out.println("核心线程数" + executor.getCorePoolSize());
//        System.out.println("线程池数" + executor.getPoolSize());
//        System.out.println("队列任务数" + executor.getQueue().size());
//
//
//        Thread.sleep(8000);
//        System.out.println("----8秒之后----");
//        System.out.println("核心线程数" + executor.getCorePoolSize());
//        System.out.println("线程池数" + executor.getPoolSize());
//        System.out.println("队列任务数" + executor.getQueue().size());

        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
    }
}
