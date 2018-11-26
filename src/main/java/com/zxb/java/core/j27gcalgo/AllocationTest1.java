package com.zxb.java.core.j27gcalgo;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/11/9
 */
public class AllocationTest1 {

    private static final int _1MB= 1024*1024;

    public static void main(String[] args) {
//        testAllocation();
        testTenuringThreshold();
    }

    private static void testTenuringThreshold(){
        byte[] a1, a2, a3;
        a1 = new byte[_1MB/4];

        a2 = new byte[4*_1MB];
        a3 = new byte[4*_1MB];
        a3 = null;
        a3 = new byte[4*_1MB];
    }

    private static void testAllocation() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2*_1MB];
        a2 = new byte[2*_1MB];
        a3 = new byte[2*_1MB];
        a4 = new byte[4*_1MB];
    }
}
