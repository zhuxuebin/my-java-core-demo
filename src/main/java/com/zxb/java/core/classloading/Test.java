package com.zxb.java.core.classloading;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/18
 */
public class Test {

    static {
        x = 0;
//        System.out.println(x); //非法向前引用对象
    }

    private static int x = 1;

    public static void main(String[] args) {
        System.out.println(Sub.x);
    }
}

class Parent{
    public static int  y = 1;
    static{
        y = 2;
    }
}

/**
 *父类会比子类优先初始化
*/
class Sub extends Parent{
    public static int x = y;
}
