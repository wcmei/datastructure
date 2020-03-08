package com.wcmei.datastructure.bf;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo3 {

    private int count = 10;

    //相当于synchronized(this)
    public synchronized void test() {
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

}
