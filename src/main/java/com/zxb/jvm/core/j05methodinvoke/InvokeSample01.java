package com.zxb.jvm.core.j05methodinvoke;

import java.util.ArrayList;

/**
 * @Description TODO
 * Created by xuery on 2018/11/25.
 */
public class InvokeSample01 {

    public static void main(String[] args) {
        InvokeSample01 invokeSample01 = new InvokeSample01();
        invokeSample01.invoke(null,1);
        invokeSample01.invoke(null,1,2);
        invokeSample01.invoke(null, new Object[]{1});

        invokeSample01.method1(1, null);
        invokeSample01.method1(1, new Object());
        invokeSample01.method1(new Integer(1),null);
    }

    public final void method1(int x, Object obj){
        System.out.println("int");
    }
    public void method1(Integer x, Object obj){
        System.out.println("Integer");
    }

    public void method1(int x, Object ... args){
        System.out.println("args");
    }

    public void invoke(Object obj, Object ...args){
        System.out.println("invoke1");
    }

    public void invoke(String s, Object obj, Object ...args){
        System.out.println("invoke2");
    }
}
