package com.zxb.java.tools.time;

import java.time.LocalTime;

/**
 * @ClassName LocalTimeExample
 * @Description 时间类，默认格式："hh:mm:ss.zzz"
 * @Author xuery
 * @Date 2019/3/22 10:58
 * @Version 1.0
 */
public class LocalTimeExample {

    public static void main(String[] args) {
        //
        LocalTime time = LocalTime.now();
        System.out.println(time);
    }
}
