package com.zxb.java.core.classloading;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/18
 */
public class ConstClass {

    static{
        System.out.println("ConstClass init");
    }

    public static final String HELLO_WORLD = "hello world";
}
