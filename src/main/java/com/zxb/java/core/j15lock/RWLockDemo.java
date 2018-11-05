package com.zxb.java.core.j15lock;

import sun.security.krb5.internal.TGSRep;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/9/26
 */
public class RWLockDemo {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private Map<String, String > map = new HashMap<>();

    public String put(String key, String value){
        writeLock.lock();
        System.out.println("write lock:"+System.currentTimeMillis());
        try{
            Thread.sleep(2000);
            return map.put(key, value);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            writeLock.unlock();
        }
    }

    public String get(String key){
        readLock.lock();
        System.out.println("read lock:"+System.currentTimeMillis());
        try{
            Thread.sleep(1000);
            return map.get(key);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        RWLockDemo rwLockDemo = new RWLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(rwLockDemo.get("1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(rwLockDemo.get("1"));
            }
        }).start();

    }
}
