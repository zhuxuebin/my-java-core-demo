package com.zxb.java.core.j03fin;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.misc.Cleaner;

/**
 * 描述：
 * 还是没怎么搞懂Cleaner作为对象回收最后一环的使用
 * @author 01368080
 * @date 2018/9/27
 */
public class CleaningExample implements AutoCloseable{

    private static final Cleaner cleaner = Cleaner.create(new Object(), new Runnable() {
        @Override
        public void run() {
            System.out.println("cleaner run");
        }
    });

    static class State implements Runnable{
        public State(){
            System.out.println("initialize state needed for cleaning action");
        }

        @Override
        public void run(){
            //cleanup action accessing State, executed at most once
            System.out.println("cleanup action accessing State, executed at most once");
        }
    }

    public static void main(String[] args) {

    }

    @Override
    public void close() throws Exception {
        cleaner.clean();
    }
}
