package com.wcmei.datastructure.bf;

import java.util.concurrent.TimeUnit;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
//一个同步方法调用父类的同步方法，能否得到锁，可以。
public class Demo10 {
    public synchronized void test() {
        System.out.println("父类同步方法 start...");
    }

    public static void main(String[] args) {
        Demo10_2 demo10_2 = new Demo10_2();
        demo10_2.test();
    }
}

class Demo10_2 extends Demo10 {
    public synchronized void test() {
        System.out.println("子类同步方法 start...");
        super.test();
    }
}
