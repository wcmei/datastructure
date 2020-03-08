package com.wcmei.datastructure.bf;

/**
 * @author wcmei
 * @date 2020-03-03
 * @description
 */
public class Demo5 implements Runnable {

    private int count = 10;

    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        for (int i = 0; i < 5; i++) {
            new Thread(demo5, "Thred" + i).start();
        }
    }

//    输出结果
//    Thred1count = 8
//    Thred2count = 8
//    Thred0count = 7
//    Thred4count = 6
//    Thred3count = 5

//    为什么会出现两个8？
//    因为多线程情况下，可能会出现下面这种情况：
//    第一个线程将count从10减到9，但是还没有进行打印，而在这之间第二个线程将9减到8，
//    就会出现第一个线程和第二个线程打印的都是8
}
