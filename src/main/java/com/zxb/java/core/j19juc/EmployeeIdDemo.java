package com.zxb.java.core.j19juc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/10/12
 */
public class EmployeeIdDemo {
    public static void main(String[] args) {
        String s = "01258378,40427167,937240,960629,960628,40040286,01352761,726269,204458,40243898,01136578," +
                "01350947,01352761,40243898,462127,40029130,40005029,40299026,40231688,40299493,1258378," +
                "40427167,937240,960629,40040286,01352761,726269,01136578,01352761,40243898,462127," +
                "40005029,40299026,40231688,40299493,40299493,01322816";
        String[] strArr = s.split(",");
        System.out.println(strArr.length);
//        for (int i = 0; i < strArr.length; i++) {
//            System.out.println(strArr[i]);
//        }
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(strArr));
        System.out.println(set.size());
        for(String ss:set){
            System.out.println(ss);
        }

        String sss = "{\"defaultFlow\":\"prod\",\"msgKey\":\"taskCode\",\"rules\":[{\"flow\":\"gray\",\"index\":1,\"ruleItem\":\"{\\\"employeeId\\\":\\\"40299493\\\"}\"},{\"flow\":\"gray\",\"index\":2,\"ruleItem\":\"{\\\"employeeId\\\":\\\"01258378\\\"}\"},{\"flow\":\"gray\",\"index\":3,\"ruleItem\":\"{\\\"employeeId\\\":\\\"40231688\\\"}\"},{\"flow\":\"gray\",\"index\":4,\"ruleItem\":\"{\\\"employeeId\\\":\\\"01322816\\\"}\"},{\"flow\":\"gray\",\"index\":5,\"ruleItem\":\"{\\\"employeeId\\\":\\\"40040286\\\"}\"},{\"flow\":\"gray\",\"index\":6,\"ruleItem\":\"{\\\"employeeId\\\":\\\"40299026\\\"}\"},{\"flow\":\"gray\",\"index\":7,\"ruleItem\":\"{\\\"employeeId\\\":\\\"462127\\\"}\"},{\"flow\":\"gray\",\"index\":8,\"ruleItem\":\"{\\\"employeeId\\\":\\\"40427167\\\"}\"},{\"flow\":\"gray\",\"index\":9,\"ruleItem\":\"{\\\"employeeId\\\":\\\"01136578\\\"}\"},{\"flow\":\"gray\",\"index\":10,\"ruleItem\":\"{\\\"employeeId\\\":\\\"40243898\\\"}\"},{\"flow\":\"gray\",\"index\":11,\"ruleItem\":\"{\\\"employeeId\\\":\\\"726269\\\"}\"},{\"flow\":\"gray\",\"index\":12,\"ruleItem\":\"{\\\"employeeId\\\":\\\"204458\\\"}\"},{\"flow\":\"gray\",\"index\":13,\"ruleItem\":\"{\\\"employeeId\\\":\\\"01352761\\\"}\"},{\"flow\":\"gray\",\"index\":14,\"ruleItem\":\"{\\\"employeeId\\\":\\\"40005029\\\"}\"},{\"flow\":\"gray\",\"index\":15,\"ruleItem\":\"{\\\"employeeId\\\":\\\"1258378\\\"}\"},{\"flow\":\"gray\",\"index\":16,\"ruleItem\":\"{\\\"employeeId\\\":\\\"960629\\\"}\"},{\"flow\":\"gray\",\"index\":17,\"ruleItem\":\"{\\\"employeeId\\\":\\\"960628\\\"}\"},{\"flow\":\"gray\",\"index\":18,\"ruleItem\":\"{\\\"employeeId\\\":\\\"937240\\\"}\"},{\"flow\":\"gray\",\"index\":19,\"ruleItem\":\"{\\\"employeeId\\\":\\\"01350947\\\"}\"},{\"flow\":\"gray\",\"index\":20,\"ruleItem\":\"{\\\"employeeId\\\":\\\"40029130\\\"}\"}]}";
        System.out.println(sss);
    }
}
