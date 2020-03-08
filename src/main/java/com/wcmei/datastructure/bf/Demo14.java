package com.wcmei.datastructure.bf;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo14 {

    public void test() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();//count++
        }
    }

    public AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Demo14 demo14 = new Demo14();
        ArrayList<Thread> threads = new ArrayList<>();

        for(int i=0;i<10;i++){
            threads.add(new Thread(demo14::test,"thread" + i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(demo14.count);
    }

//    输出结果：100000
//    这时并没有volatile和synchronized，但是由于AtomicInteger即保证了可见性又保证了原子性
//    但是，atomic类连续调用（原子操作）不能构成原子性，因为多个操作就不是原子操作了，比如下面这个代码
//    for (int i = 0; i < 10000; i++) {
//        if(count.get()<10000){                      //这是一个原子操作
//            count.incrementAndGet();//count++       //这又是一个原子操作
//        }
//    }


    //volatile和synchronized区别
    //答：volatilez只保证了可见性，synchronized既保证了可见性又保证了原子性
}
