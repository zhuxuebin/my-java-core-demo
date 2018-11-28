package com.zxb.jvm.core.j06throwable;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/26
 */
public class Foo1 {

    private int tryBlock;

    private int catchBlock;

    private int finallyBlock;

    private int methodExit;

    public void test() {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
        }
        methodExit = 3;
    }
}
