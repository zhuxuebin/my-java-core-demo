package com.zxb.jvm.core.j06throwable;

import java.io.IOException;

/**
 * 描述：在try...catch...finally中的finally return会吞掉catch抛出的异常，导致异常无法抛出
 *
 * 最好不要在finally return
 * @author xuery
 * @date 2018/11/26
 */
public class Foo3 {

    private int tryBlock;

    private int catchBlock;

    private int finallyBlock;

    private int methodExit;

    public static void main(String[] args) throws Exception {
        Foo3 foo3 = new Foo3();
        System.out.println(foo3.test());
    }

    public int test() {

        try {
            tryBlock = 1 / 0;
//        } catch (Exception e) {
//            catchBlock = 1;
//            return 1;
        } finally {
            finallyBlock = 2;
            return 2;
        }
    }
}
