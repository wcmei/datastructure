package com.wcmei.datastructure.bf;

import java.util.concurrent.TimeUnit;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo11 {

    private int count = 0;

    public synchronized void test() {
        System.out.println(Thread.currentThread().getName() + "start...");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0;
            }
        }
    }

    public static void main(String[] args) {
        Demo11 demo11 = new Demo11();
        Runnable r = () -> demo11.test();
        new Thread(r, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "t2").start();
    }
//    输出结果
//    t1start...
//    t1count=1
//    t1count=2
//    t1count=3
//    t1count=4
//    t1count=5
//    t2start...
//    t2count=6
//    Exception in thread "t1" java.lang.ArithmeticException: / by zero
//    at com.wcmei.datastructure.bf.Demo11.test(Demo11.java:25)
//    at com.wcmei.datastructure.bf.Demo11.lambda$main$0(Demo11.java:32)
//    at java.lang.Thread.run(Thread.java:748)
//    t2count=7
//    t2count=8
//    t2count=9
//    t2count=10
//    t2count=11
//    ...

//    当线程t1将count加到5时，会发生算数异常，这时候线程t1让出了锁给t2，t2会之前的进度继续执行。
//    这样会导致程序不可控，解决方案是对异常进行捕获（try，catch），
//    这样会在发生异常后让所有的线程都中止操作

}
