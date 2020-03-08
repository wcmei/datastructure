package com.wcmei.datastructure.bf;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo1 {

    private int count = 10;
    private Object object = new Object();

    public void test() {
        synchronized (object) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }

}
