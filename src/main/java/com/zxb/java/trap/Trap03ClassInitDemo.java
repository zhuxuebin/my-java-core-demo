package com.zxb.java.trap;

/**
 * @ClassName Trap03ClassInitDemo
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/20 11:46
 * @Version 1.0
 */
public class Trap03ClassInitDemo {

    final String result;

    public Trap03ClassInitDemo(String x, String y){
        this.result = add(x,y);
    }

    public String add(String x, String y){
        return x+y;
    }

    static class SubClass extends Trap03ClassInitDemo{
        String z;

        public SubClass(String x, String y, String z){
            super(x,y);
            this.z = z;
        }

        public String add(String x, String y){
            return super.add(x,y)+z;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubClass("A","B","C").result);
    }
}
