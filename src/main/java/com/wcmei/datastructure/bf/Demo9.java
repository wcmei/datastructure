package com.wcmei.datastructure.bf;

import java.util.concurrent.TimeUnit;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
//一个同步方法调用另外一个同步方法，能否得到锁
public class Demo9 {

    public synchronized void test1(){
        System.out.println("test1 start...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2();
    }

    public synchronized void test2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test2 start...");
    }

    public static void main(String[] args) {
        Demo9 demo9 = new Demo9();
        demo9.test1();
    }

//    输出结果
//    test1 start...
//    test2 start...
//    即，一个同步方法调用另外一个同步方法，能得到锁
//    synchronized支持重路锁

}
