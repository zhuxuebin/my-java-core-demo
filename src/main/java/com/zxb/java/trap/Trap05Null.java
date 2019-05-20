package com.zxb.java.trap;

/**
 * @ClassName Trap05Null
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/20 14:23
 * @Version 1.0
 */
public class Trap05Null {

    public static void greet(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {

        //静态方法，null对象也可以调用
        Trap05Null x = null;
        x.greet();
        ((Trap05Null)x).greet();
        ((Trap05Null) null).greet();

    }
}
