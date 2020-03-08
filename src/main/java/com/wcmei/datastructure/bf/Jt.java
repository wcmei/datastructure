package com.wcmei.datastructure.bf;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Jt {
    public volatile int i = 1;
    Object o = new Object();

    public void test() {
        synchronized (o) {
            for (; i < 101; ) {
                System.out.println(Thread.currentThread().getName() + "=" +i++);
                try {
                    o.notify();
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            o.notifyAll();
        }
    }

    public static void main(String[] args) {
        Jt jt = new Jt();
        new Thread(jt::test, "奇数线程t1").start();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(jt::test, "偶数线程t2").start();
    }

}
