package com.zxb.java.core.j23generateclass;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/31
 */
public class RealSubject implements Subject {

    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
