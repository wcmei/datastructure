package com.wcmei.datastructure.bf;

import java.util.concurrent.TimeUnit;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo12 {

    private boolean running = true;
//    private volatile boolean running = true;

    public void test(){
        System.out.println("test start...");
        while (running){
//            System.out.println("wait...");
        }
        System.out.println("test end...");
    }

    public static void main(String[] args) {
        Demo12 demo12 = new Demo12();
        new Thread(demo12 :: test,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo12.running = false;
    }

//    "test end..."永远不会输出，有两种情况能够使其输出：
//    第一种情况：running变量添加关键字volatile
//    第二种情况：在while循环体中写入任意代码
//
//    计算机中的线程通信有两种：内存共享，消息通知
//    Java采用的是内存共享
//
//    在Java内存模型中（JMM），所有数据都在这一大块里面，
//    而每个线程是向操作系统申请一块独立的内存（堆内存之外，不属于虚拟机直接内存）
//
//    main方法是一个主线程，t1是另一个线程，当在主线中main方法中将running变量设为false，
//    此时t1线程没有刷新cpu的缓冲区，所以不知道running的改变，而使用了volatile关键字之后，
//    会保证数据是可见的，即CPU缓冲区在数据发送改变时会立即刷新，这才使得t1线程看到running
//    变为了false。

//    而在while循环体中写入代码，是因为cpu空闲的时候会对缓冲区刷新，而到底什么时候空闲就要问酷睿和AMD了

}
