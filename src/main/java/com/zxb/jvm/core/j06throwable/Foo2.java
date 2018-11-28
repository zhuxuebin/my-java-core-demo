package com.zxb.jvm.core.j06throwable;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/26
 */
public class Foo2 {

    private int tryBlock;

    private int catchBlock;

    private int finallyBlock;

    private int methodExit;

    public void test() {
        for (int i = 0; i < 100; i++) {
            try {
                tryBlock = 0;
                if (i < 50) {
                    continue;
                } else if (i < 80) {
                    break;
                } else {
                    return;
                }
            } catch (Exception e) {
                catchBlock = 1;
            } finally {
                finallyBlock = 2;
            }
        }
        methodExit = 3;
    }
}
