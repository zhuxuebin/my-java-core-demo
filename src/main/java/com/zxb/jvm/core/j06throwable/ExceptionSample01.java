package com.zxb.jvm.core.j06throwable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/26
 */
public class ExceptionSample01 {

    public static void main(String[] args) {
        try{
            exceptionMethod1();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void exceptionMethod1() throws  IOException{
        try(InputStream inputStream = new FileInputStream("1.txt")) {
            inputStream.available();
        }catch (IOException e){
//            e.printStackTrace();
            throw  new IOException("other Exception");
        }
    }
}
