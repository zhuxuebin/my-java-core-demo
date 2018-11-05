package com.zxb.java.core.classloading;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/18
 */
public class SuperClass {
    static{
        System.out.println("SuperClass init");
    }

    public static int value = 123;
}
