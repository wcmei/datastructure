package com.wcmei.datastructure.bf;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo2 {

    private int count = 10;

    public void test() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }

}
