package com.wcmei.datastructure.bf;

import java.util.concurrent.TimeUnit;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo8 {

    private String name;
    private double balance;

    public synchronized void setName(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();
        new Thread(() -> demo8.setName("wan", 100)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo8.getBalance("wan"));//输出结果：0.0

        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo8.getBalance("wan"));//输出结果100.0
    }

    //查询结果出现了脏读，这是因为只对写入加锁，未对查询加锁
    //实际情况的查询是否加锁要根据业务情况

    //如果要保证第一次查询结果为100.0，则对getBalance(String name)加锁即可

}
