package com.zxb.java.core.j23generateclass;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/11/1
 */

public class Test {
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(5, 3);
        int c = a.area(b);
        Integer i1 = 15;
        Integer i2 = 15;
        Integer newVal1 = new Integer(15);
        Integer newVal2 = new Integer(15);
        Integer valueOf1 = Integer.valueOf(15);
        Integer valueOf2 = Integer.valueOf(15);
        System.out.println();

        List<String> taskBagNos = Arrays.asList("1","2","3");
        List<String> updateBagNos = Arrays.asList("2","3","4");
        if(CollectionUtils.isNotEmpty(taskBagNos)){
            for(String taskBagNo : taskBagNos){
                System.out.println(taskBagNo);
                if(!updateBagNos.contains(taskBagNo)){
                    System.out.println("!!!");
                    break;
                }
            }
        }

        List<String> sss = taskBagNos.stream().filter(s->"4".equals(s)).collect(Collectors.toList());
        System.out.println(sss);

        String s1 = "1111",s2 = null;
        String s3 = s1 + s2;
        System.out.println(s3);
    }
}
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int area(Point b) {
        int length = Math.abs(b.y - this.y);
        int width = Math.abs(b.x - this.x);
        return length * width;
    }
}
