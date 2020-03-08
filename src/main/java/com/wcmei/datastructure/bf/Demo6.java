package com.wcmei.datastructure.bf;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo6 implements Runnable {

    private int count = 10;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        for (int i = 0; i < 5; i++) {
            new Thread(demo6, "Thred" + i).start();
        }
    }

//    输出结果
//    Thred0count = 9
//    Thred2count = 8
//    Thred4count = 7
//    Thred3count = 6
//    Thred1count = 5

//    因为对同一个Demo6实例的run()方法加了锁，所以count按顺序输出

}
