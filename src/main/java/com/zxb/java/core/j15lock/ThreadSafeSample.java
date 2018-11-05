package com.zxb.java.core.j15lock;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/20
 */
public class ThreadSafeSample {

    public int sharedState;

    public void nonSafeAction(){
        while(sharedState < 100000){
            synchronized (this) {
                int former = sharedState++;
                int latter = sharedState;
                if (former != latter - 1) {
                    System.out.println("observed data race, former is " + former + ", latter is " + latter);
                }
            }
        }
    }

    public static void main(String[] args) {

        ThreadSafeSample threadSafeSample = new ThreadSafeSample();
        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadSafeSample.nonSafeAction();
                }
            }).start();
        }
    }
}
