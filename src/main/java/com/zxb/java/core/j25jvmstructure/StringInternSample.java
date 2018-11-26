package com.zxb.java.core.j25jvmstructure;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/11/7
 */
public class StringInternSample {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = s1.intern();
        System.out.println(s1 == s2); //true
    }
}
