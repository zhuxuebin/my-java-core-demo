package com.zxb.java.core.classloading;

/**
 * 描述：
 *  被动引用示例3：
 *  常量在编译阶段就存入常量池了，本质上并没有引用类的变量，所以不会触发初始化
 * @author 01368080
 * @date 2018/9/18
 */
public class NotInitialization03 {

    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO_WORLD);
    }
}
