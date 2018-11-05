package com.zxb.java.core.j19juc;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/17
 */
public class QuoteSample {

    public static void main(String[] args) {
        EmployeeIdDemo employeeIdDemo = new EmployeeIdDemo();
        EmployeeIdDemo copy = employeeIdDemo;
        employeeIdDemo = null;
        System.out.println(employeeIdDemo);
        System.out.println(copy);
    }
}
