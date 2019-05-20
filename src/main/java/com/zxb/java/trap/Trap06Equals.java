package com.zxb.java.trap;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Trap06Equals
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/20 14:28
 * @Version 1.0
 */
public class Trap06Equals {

    private String first,last;

    public Trap06Equals(String first, String last){
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o){
        Trap06Equals n = (Trap06Equals) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    @Override
    public int hashCode(){
        return first.hashCode()+last.hashCode();
    }

    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(new Trap06Equals("1","2"));
        System.out.println(s.contains(new Trap06Equals("1","2")));
    }
}
