package com.zxb.java.trap;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Trap02StrangeNumber
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/20 11:04
 * @Version 1.0
 */
public class Trap02StrangeNumber {

    public static void main(String[] args) {
        //1. 别用l，主要是容易眼花
        //1.1 变量结尾不要用l，long类型必须用L
        System.out.println(12345 + 5432l);

        //1.2 变量名别用l
        List l = new ArrayList<>();
        l.add("Foo");
        System.out.println(l);

        //2. byte与int比较时，或者说不同范围的类型比较时，会统一转换成：窄类型，会进行有符号扩展[当成有符号数]
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x99) {
                System.out.println("found it");
            }
        }

        System.out.println((byte) 0x99);
        System.out.println(0x99);

        //3. x+=1 x=x+1在类型转换中的区别
        byte x = 10;
        x += 1234; //会自动强转为byte类型，1234被当成有符号数
//        x = x + 1234;//报错,左边是byte类型，右边byte+int=int，不匹配
        System.out.println(x);

        Object taotao = "taotao";
        String ali = "ali";
        taotao = taotao+ali;
        System.out.println("taotao1:"+taotao);
        taotao += ali;
        System.out.println("taotao2:"+taotao);

        //4. 不要太指望 == 和常量池intern
        String s = "who";
        System.out.println("who" == s); //true
        System.out.println("who" == "who"); //true
        System.out.println("who" == new String("who")); //false
        System.out.println("who" == new String("who").intern()); //true

        //5.
    }
}
