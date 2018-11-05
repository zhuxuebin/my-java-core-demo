package com.zxb.java.core.classloading;

/**
 * 描述：
 * 被动引用示例1：对于静态字段，只有定义该字段的类才会被初始化，子类引用不行
 * @author 01368080
 * @date 2018/9/18
 */
public class NotInitialization01 {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
