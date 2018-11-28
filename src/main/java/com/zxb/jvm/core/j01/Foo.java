package com.zxb.jvm.core.j01;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/27
 */
public class Foo {
    public static void main(String[] args) {
        boolean flag = true;
        if(flag){
            System.out.println("Hello, java");
        }
        if(flag == true){
            System.out.println("Hello jvm");
        }
    }
}
