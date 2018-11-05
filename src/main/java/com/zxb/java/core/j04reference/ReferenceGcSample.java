package com.zxb.java.core.j04reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 描述：
 * 参考：https://blog.csdn.net/javaiamnihao/article/details/81507210
 * @author 01368080
 * @date 2018/9/27
 */
public class ReferenceGcSample {

    public static void main(String[] args) {
        WeakReference<ReferenceGcSample> referenceGcSample = new WeakReference<ReferenceGcSample>(new ReferenceGcSample());
        System.gc();
        System.out.println(referenceGcSample.get());
        // new一个20M的byte数组，使堆空间不足，进而触发gc
//        byte[] bytes = new byte[1024 * 1024 * 20];
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(this +" is gc");
    }
}
