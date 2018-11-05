package com.zxb.java.core.j19juc;

import java.util.concurrent.Semaphore;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/10
 */
public class AbnormalSemaphoreSample {

    public static void main(String[] args) throws Exception{
        Semaphore semaphore = new Semaphore(0);
        for(int i=0;i<10;i++){
            new Thread(new MyWoker(semaphore)).start();
        }

        System.out.println("round1========");
        semaphore.release(5);
        System.out.println("wait for permits off");
        while(semaphore.availablePermits()!=0){
            Thread.sleep(1000L);
        }
        System.out.println("round2=========");
        semaphore.release(5);
    }
}

class MyWoker implements Runnable{
    private Semaphore semaphore;
    public MyWoker(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    @Override
    public void run(){
        try{
            semaphore.acquire();
            System.out.println("executed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
