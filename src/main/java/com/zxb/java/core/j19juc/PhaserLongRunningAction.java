package com.zxb.java.core.j19juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * 描述：
 * Phaser理解，加强版CountDownLatch
 * 1. 调用Phaser的register会将当前线程注册在Phaser上，每注册一个计数器加1
 * 2. 调用Phaser.arriveAndAwaitAdvance当计数器累加到注册数时通过栅栏，类似于CountDownLatch.countdown
 * 3. 调用Phaser.arriveAndDeregister();是会将当前线程从Phaser注销掉
 * 3. 可以继续使用register, 当再次注册时，会将计数器继续累加，之前调用了Phaser.arriveAndAwaitAdvance但是未调用arriveAndDeregister注销的计数仍然有效
 * 意思就是想让线程继续往下执行，则除了再注册的需要调用arriveAndAwaitAdvance外，之前未注销的需要再次调用arriveAndAwaitAdvance方法后续才能通过屏障
 * 4. phaser.getPhase的值是指当前Phaser第几批次被循环使用
 * @author 01368080
 * @date 2018/10/11
 */
class PhaserLongRunningAction implements Runnable {
    private String threadName;
    private Phaser ph;

    public static void main(String[] args) {
        //given
        ExecutorService executorService = Executors.newCachedThreadPool();
        Phaser ph = new Phaser(1);
        System.out.println(ph.getPhase() == 0);

        //when
        executorService.submit(new PhaserLongRunningAction("thread-1", ph));
        executorService.submit(new PhaserLongRunningAction("thread-2", ph));
        executorService.submit(new PhaserLongRunningAction("thread-3", ph));

        //then
        ph.arriveAndAwaitAdvance();
        System.out.println(ph.getPhase() == 1);

        //and
        executorService.submit(new PhaserLongRunningAction("thread-4", ph));
        executorService.submit(new PhaserLongRunningAction("thread-5", ph));
        ph.arriveAndAwaitAdvance();
        System.out.println(ph.getPhase() == 2);

        //loop3
        executorService.submit(new PhaserLongRunningAction("thread-6", ph));
        executorService.submit(new PhaserLongRunningAction("thread-7", ph));
        ph.arriveAndAwaitAdvance();
        System.out.println(ph.getPhase() == 3);

        ph.arriveAndDeregister();
    }

    PhaserLongRunningAction(String threadName, Phaser ph) {
        this.threadName = threadName;
        this.ph = ph;
        ph.register();
    }

    @Override
    public void run() {
        System.out.println("This is phase " + ph.getPhase());
        System.out.println("Thread " + threadName + " before long running action");
        ph.arriveAndAwaitAdvance();
        try {
            System.out.println(threadName + " executed");
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ph.arriveAndDeregister();
    }
}
