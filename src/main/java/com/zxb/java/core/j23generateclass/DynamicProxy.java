package com.zxb.java.core.j23generateclass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述：参考如下
 *  http://www.cnblogs.com/duanxz/archive/2012/12/03/2799504.html
 * @author 01368080
 * @date 2018/10/31
 */
public class DynamicProxy implements InvocationHandler {

    //需要被动态代理的对象
    private Subject subject;

    public DynamicProxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before------");

        method.invoke(subject, args);

        System.out.println("end------");

        return null;
    }


}
