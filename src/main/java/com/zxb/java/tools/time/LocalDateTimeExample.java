package com.zxb.java.tools.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName LocalDateTimeExample
 * @Description 日期-时间类，默认格式："yyyy-MM-dd-HH-mm-ss.zzz", 应该是最常用的一个类了
 * @Author xuery
 * @Date 2019/3/22 11:00
 * @Version 1.0
 */
public class LocalDateTimeExample {

    public static void main(String[] args) {
        //
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        //组合LocalDate和LocalTime
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(today);

        //format
        String formatPattern = "yyyy-MM-dd HH:mm:ss";
        String todayStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatPattern));
        System.out.println(todayStr);

        //前后几个小时的时间
        String beforeHours = LocalDateTime.now().minusHours(2).format(DateTimeFormatter.ofPattern(formatPattern));
        String afterHours = LocalDateTime.now().plusHours(2).format(DateTimeFormatter.ofPattern(formatPattern));
        System.out.println("before 2 hours time:"+beforeHours);
        System.out.println("after 2 hours time:"+afterHours);

        //字符串转换成时间
        LocalDateTime dt = LocalDateTime.parse("2017-09-01 12:00:01",DateTimeFormatter.ofPattern(formatPattern));
        System.out.println("str to LocalDateTime:"+dt);

        //旧数据转换成新数据
        Instant timestamp = new Date().toInstant();
        LocalDateTime dateTime = LocalDateTime.ofInstant(timestamp, ZoneId.of(ZoneId.SHORT_IDS.get("CTT")));
        System.out.println("Date to LocalDateTime:"+dateTime);
    }
}
