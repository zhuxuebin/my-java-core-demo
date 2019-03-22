package com.zxb.java.tools.time;

import java.time.LocalDate;

/**
 * @ClassName LocalDateExample
 * @Description 日期类，默认格式："yyyy-MM-dd"
 * @Author xuery
 * @Date 2019/3/22 10:50
 * @Version 1.0
 */
public class LocalDateExample {

    public static void main(String[] args) {

        //current date
        LocalDate today = LocalDate.now();
        System.out.println("current date:"+today);

        //
        LocalDate firstDay_2014 = LocalDate.of(2014,1,1);
        System.out.println("first day of 2014:"+firstDay_2014);

        //
        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014,100);
        System.out.println(hundredDay2014);
    }
}
