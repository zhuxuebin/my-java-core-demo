package com.zxb.java.core.j17thread;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/28
 */
public class VolatileSample {

    private volatile int volatileCounter = 0;

    private int normalCounter = 0;

    public static void main(String[] args) {
        VolatileSample sample = new VolatileSample();

        sample.counterMethod();
    }

    public void counterMethod(){

        volatileCounter = 10;

        normalCounter = 11;
    }
}
