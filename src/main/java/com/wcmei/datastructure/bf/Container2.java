package com.wcmei.datastructure.bf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
//实现一个容器，提供两个方法，add，size
//写两个线程，线程1添加10个元素到容器中，线程2实现监控容器的个数，当个数达到5时，线程2给出提示并结束
public class Container2 {
    public volatile List lists = new ArrayList();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        Container2 c = new Container2();

        new Thread(()->{
            for(int i=0;i<10;i++){
                c.add(new Object());
                System.out.println("add" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            while(true){
                if(c.size() == 5){
                    break;
                }
            }
            System.out.println("线程2结束");
        },"t2").start();
    }

    //结果，t2线程会结束，但是不一定是在个数达到5时结束
    //因为，从t2线程看到个数为5到t2线程中止之间，t1线程可能已经将个数加到6或7了（存在延迟）
    //而且，t2线程前面一直在while死循环会浪费资源

}
