package com.zxb.java.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ListRemoveElementExample
 * @Description 不通过下标访问for循环，用list.remove(ele);可能会报错的原因验证
 *
 * 用iterator或者下标访问remove就没有问题
 *
 * @Author xuery
 * @Date 2019/3/25 11:00
 * @Version 1.0
 */
public class ListRemoveElementExample {

    public static void main(String[] args) {


    }

    public static void forEachRemoveElement(){
        /**
         * 报错原因：sList.remove(s)时modCount加1，但是expectedModCount未加1，导致下一次遍历时，
         * 这种for循环遍历其实是采用iterator遍历的，会先检查modCount ?= expectedModCount，不相等则抛出ConcurrentModificationException
         */
        List<String> sList = new ArrayList<>(Arrays.asList("1","2","3"));
        for(String s : sList){
            if(s.equals("1")){
                sList.remove(s);
            }
            System.out.println(sList);
        }
    }

    public static void forRemoveElement(){
        
    }
}
