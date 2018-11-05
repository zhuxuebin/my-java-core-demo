package com.zxb.java.core.j21executorpool;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/22
 */
public class SynchronizedDemo {

    private String lock = new String();

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.synchronizedMethod();
    }

    public void synchronizedMethod(){
        synchronized (lock){
            System.out.println("first lock");
            synchronized (lock){
                System.out.println("second lock");
            }
        }
    }
}
