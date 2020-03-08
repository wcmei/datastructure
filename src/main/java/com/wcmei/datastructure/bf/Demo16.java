package com.wcmei.datastructure.bf;

import java.util.concurrent.TimeUnit;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo16 {

    public Object o =new Object();

    public void test(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "正在执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo16 demo16 = new Demo16();

        new Thread(demo16::test,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(demo16::test, "t2");

        demo16.o =new Object();
        //t2能否执行
        t2.start();

        //t2能够执行
        //因为锁的对象改变了，锁是来锁住对象的
    }

}
