package com.zxb.java.core.j19juc;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/10
 */
public class SemaphoreSample {

    public static void main(String[] args) {
        SemaphorePool pool = new SemaphorePool();
        for (int i = 0; i < 20; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Object obj = pool.getItem();
                        if (obj != null) {
                            //获取信号量成功则执行
                            System.out.println("execute thread " + index);
                            Thread.sleep(1000);
                            //执行完毕释放信号量
                            pool.putItem(obj);
                        } else {
                            System.out.println("fail to execute " + index);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
