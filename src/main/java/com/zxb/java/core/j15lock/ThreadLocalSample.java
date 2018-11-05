package com.zxb.java.core.j15lock;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/27
 */
public class ThreadLocalSample {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.get();
        threadLocal.set("11");
        threadLocal.remove();
    }
}
