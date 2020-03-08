package com.wcmei.datastructure.bf;

import java.util.ArrayList;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo13 {

    public volatile int count = 0;

    public void test() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Demo13 demo13 = new Demo13();
        ArrayList<Thread> threads = new ArrayList<>();

        for(int i=0;i<10;i++){
            threads.add(new Thread(demo13::test,"thread" + i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(demo13.count);
    }

//    输出结果：37759
//    如果要让结果为100000，只有对test()方法加锁
//    因为volatile只能保证可见性，不能保证原子性

//    补充：第一个线程将count加到了100，这时其它线程均可以看到count的值为100（可见性）
//    但是，在第一个线程将100加到101但是还没有写入到内存时，它并不会通知其它线程说我
//    已经将count加到101了，你们要从101开始加，这就是不保证原子性

}
