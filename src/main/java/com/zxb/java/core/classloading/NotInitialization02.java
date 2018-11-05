package com.zxb.java.core.classloading;

/**
 * 描述：
 * 被动引用示例2：通过数组定义来引用类，不会触发类的初始化
 * @author 01368080
 * @date 2018/9/18
 */
public class NotInitialization02 {

    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}
