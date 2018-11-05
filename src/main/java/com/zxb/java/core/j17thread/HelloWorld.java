package com.zxb.java.core.j17thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/27
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("hello world!!");
        //1.MXBean
        System.out.println("===========方法1：MXBean方法线程列表=============");
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.getAllThreadIds();
        ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
        for(ThreadInfo threadInfo : threadInfos){
            System.out.println(threadInfo.getThreadId()+": "+threadInfo.getThreadName());
        }

        //2.ThreadGroup
        System.out.println("===========方法2：ThreadGroup方法线程列表===========");
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        while(group != null){
            topGroup = group;
            group = group.getParent();
        }

        int threadCount = topGroup.activeCount();
        System.out.println("threadCount: "+threadCount);
        Thread[] threads = new Thread[threadCount];
        topGroup.enumerate(threads);
        for(int i=0;i<threadCount;i++){
            System.out.println(threads[i].getId()+": "+threads[i].getName());
        }
    }
}
