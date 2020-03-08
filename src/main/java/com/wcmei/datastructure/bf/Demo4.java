package com.wcmei.datastructure.bf;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo4 {

    private static int count = 10;

    //用于静态方法，锁住的是XXX.class
    public synchronized static void test() {
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

    public static void test2(){
        //能否替换成this？
        //不能，因为静态方法可以不需要实例对象，直接由类调用
        synchronized (Demo4.class){
            count--;
        }
    }

}
