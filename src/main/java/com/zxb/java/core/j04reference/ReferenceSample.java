package com.zxb.java.core.j04reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/27
 */
public class ReferenceSample {

    public static void main(String[] args) {
        //幻想引用
        Object counter = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Reference<Object> reference = new PhantomReference<>(counter, referenceQueue);
        System.out.println(reference.get());

        counter = null;
        System.gc();
        try{
            Reference<?> ref = referenceQueue.remove(1000L);
            if(ref != null){
                System.out.println("do sth");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
