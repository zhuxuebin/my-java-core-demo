package com.zxb.jvm.core.j05methodinvoke;

import java.io.IOException;

/**
 * @Description TODO
 * Created by xuery on 2018/11/25.
 */
public class SubClass extends ParentClass {

    public static  int staticMethod1(){
        return 0;
    }

    @Override
    public SubClass method1() throws IOException{
        return null;
    }
}
