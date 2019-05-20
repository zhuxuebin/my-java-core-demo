package com.zxb.java.trap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Trap01Iterator
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/20 10:49
 * @Version 1.0
 */
public class Trap01Iterator {

    public static void main(String[] args) {

        /**
         * Trap01: 问题cookieSet.iterator().hasNext()，每次都是取迭代器的第一个元素，因为每次都是重新取cookieSet.iterator()
         */
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        Set<Map.Entry<String,String>> cookieSet = map.entrySet();
//        while(cookieSet.iterator().hasNext()){
//            Map.Entry entry = cookieSet.iterator().next();
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }

        /**
         * 解决方法：既然打算用set，就别用迭代器了，直接forEach就可以了
         */
        for(Map.Entry<String,String> entry : cookieSet){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
