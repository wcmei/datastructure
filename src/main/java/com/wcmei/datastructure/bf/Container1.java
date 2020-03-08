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
public class Container1 {
    public volatile List lists = new ArrayList();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        Container1 c = new Container1();

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

    //结果，t1线程一直输出，t2线程不会结束
    //因为lists是在缓冲区的，没有保证可见性

}
