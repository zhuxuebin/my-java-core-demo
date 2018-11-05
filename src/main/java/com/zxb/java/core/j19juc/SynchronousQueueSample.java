package com.zxb.java.core.j19juc;

import org.springframework.util.Assert;

import java.util.concurrent.*;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/17
 */
public class SynchronousQueueSample {

    public static void main(String[] args) throws Exception {
        ExecutorService es2 = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(2);
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        Runnable producer = () -> {
            Integer producerElement = ThreadLocalRandom.current().nextInt();
            try {
                synchronousQueue.put(producerElement);
                System.out.println("producer produce " + producerElement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            try {
                Integer consumerElement = synchronousQueue.take();
                System.out.println("consumer consume " + consumerElement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        es.execute(producer);
        es.execute(consumer);

        es.awaitTermination(500, TimeUnit.MILLISECONDS);
        es.shutdown();
        System.out.println(synchronousQueue.size());
    }
}
