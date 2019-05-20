package com.zxb.java.trap;

/**
 * @ClassName Trap04FinallyDemo
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/20 14:03
 * @Version 1.0
 */
public class Trap04FinallyDemo {

    static int value = 0;
    static int inc(){
        return value++;
    }
    static int dec(){
        return value--;
    }

    static int getResult(){
        try{
            return inc();
        } finally {
            return dec(); //这里的return会覆盖try中的return语句
        }
    }

    public static void main(String[] args) {
        System.out.println(getResult());
        System.out.println(value);
    }
}
