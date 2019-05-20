package com.zxb.java.trap;

/**
 * @ClassName Trap07HiddenParent
 * @Description TODO 没搞懂
 * @Author xuery
 * @Date 2019/5/20 16:21
 * @Version 1.0
 */
public class Trap07HiddenParent {

    public String name="parent";

    public static void main(String[] args) {
        System.out.println(new Child().name);
    }
}

class Child extends Trap07HiddenParent{
    protected String name = "child";
}
