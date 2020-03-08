package com.wcmei.datastructure.bf;

import java.util.concurrent.TimeUnit;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
//字符串常量当锁有没有问题
public class Demo17 {

    public String s1 = "hello";
    public String s2 = "hello";

    public void test1(){
        synchronized (s1){

        }
    }

    public void test2(){
        synchronized (s2){

        }
    }

    //肯定是有问题的，因为他们是同一把锁
    //比如有个程序使用"hello"当锁，当它的一个线程在占用这个锁执行程序时，
    //另外有个程序也使用"hello"常量当锁，这时这个程序就无法启动需要该锁的一个线程
    //因为它们时同一把锁，而锁已经被其它线程占用了
}
