package com.zxb.java.core.j15lock;

import java.util.concurrent.locks.StampedLock;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/26
 */
public class StampedSample {

    private final StampedLock sl = new StampedLock();

    void mutable(){
        long stamp = sl.tryOptimisticRead();
        sl.validate(stamp);
    }
}
