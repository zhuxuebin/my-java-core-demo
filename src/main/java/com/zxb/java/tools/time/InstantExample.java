package com.zxb.java.tools.time;

import java.time.Instant;

/**
 * @ClassName InstantExample
 * @Description 时间戳
 * @Author xuery
 * @Date 2019/3/22 14:25
 * @Version 1.0
 */
public class InstantExample {

    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println("current timestamp="+timestamp);
    }
}
