package com.wcmei.datastructure.bf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
//实现一个容器，提供两个方法，add，size
//写两个线程，线程1添加10个元素到容器中，线程2实现监控容器的个数，当个数达到5时，线程2给出提示并结束
public class Container3 {
    public volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        Container3 c = new Container3();

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add" + i);

                    if(c.size() == 5){
                        lock.notify();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程t2启动");
                if (c.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2线程结束");
            }
            System.out.println("线程2结束");
        }, "t2").start();
    }

    //结果，t2线程不会在个数为5时结束
    //因为t1线程调用notify()方法虽然唤醒了线程2，但是t1并没有释放锁

}
