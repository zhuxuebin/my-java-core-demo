package com.zxb.java.core.j19juc;

import java.util.concurrent.Semaphore;

/**
 * 描述：
 * 简化的信号量池
 *
 * @author 01368080
 * @date 2018/10/10
 */
public class SemaphorePool {

    private static final int MAX_AVAILABLE = 10;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    protected Object[] items = new Integer[MAX_AVAILABLE];
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    public SemaphorePool() {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            items[i] = i;
        }
    }

    /**
     * 获取一个信号量
     *
     * @return
     * @throws InterruptedException
     */
    public Object getItem() throws InterruptedException {
        //阻塞的
        available.acquire();
        return getNextAvailableItem();
    }

    /**
     * 将用完的信号量归还到池中
     *
     * @param x
     */
    public void putItem(Object x) {
        if (markAsUnused(x)) {
            available.release();
        }
    }

    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null;
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
