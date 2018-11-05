package com.zxb.java.core.j19juc;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/12
 */
public class ConcurrentDemo {

    public static void main(String[] args) throws Exception {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<>();
        clq.offer("1");
        clq.offer("2");
        clq.offer("3");

        SynchronousQueue sq = new SynchronousQueue();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>(16);
        for (int i = 0; i < 1; i++) {
            lbq.put(String.valueOf(i));
        }
        String takeStr = lbq.take();
        System.out.println();
//                ArrayList;
        while (true) {
            List<Integer> list = new ArrayList<>();
            int MAX_THREADS = 10000;
            CountDownLatch countDownLatch = new CountDownLatch(MAX_THREADS);
            for (int i = 0; i < MAX_THREADS; i++) {
                final int index = i;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                    synchronized (list) {
                        list.add(index);
                        countDownLatch.countDown();
//                    }
                    }
                }).start();
            }
            countDownLatch.await();
//            if (list.size() != MAX_THREADS) {
                System.out.println(list.size());
//            }
            Thread.sleep(100L);
        }
    }
}
