package com.zxb.java.core.j29happendbefore;

/**
 * @Description TODO
 * Created by xuery on 2018/12/10.
 */
public class VolatileSample {

    private static volatile boolean flag = false;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        flag = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!flag) {
                        //System.out.println("while");
                    }
                    System.out.println("break while"+index);
                }
            }).start();
        }
    }
}
