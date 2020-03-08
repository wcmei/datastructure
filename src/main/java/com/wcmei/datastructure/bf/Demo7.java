package com.wcmei.datastructure.bf;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo7 {

    public synchronized void test1(){
        System.out.println(Thread.currentThread().getName() + "test1 start ...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "test1 end ...");
    }
    
    public void test2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "test2 end ...");
    }

    public static void main(String[] args) {
        Demo7 demo7 = new Demo7();
        new Thread(demo7 :: test1,"test1").start();
        new Thread(demo7 :: test2,"test2").start();
    }

//    输出结果
//    test1test1 start ...
//    test2test2 end ...
//    test1test1 end ...
//
//    结论：同步方法和非同步方法可以同时调用

}
