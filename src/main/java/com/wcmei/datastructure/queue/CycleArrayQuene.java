package com.wcmei.datastructure.queue;

/**
 * @author wcmei
 * @date 2020-01-09
 * @description
 */
public class CycleArrayQuene {
    private int[] arr;
    private int maxSize;
    private int front;
    private int rear;

    public CycleArrayQuene(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        //取余表示单个数组添加到的第几位
        //front表示单个数组中的刚刚取到第几位
        //两者相等，表示形成闭环，即已存满
        //+1表示预留一个位置，因为一开始front和rear都是0，如果不这样一开始队列就是满的
        return (rear + 1) % maxSize == front;
    }

    //有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void addQuene(int element) {
        if (isFull()) {
            throw new RuntimeException("队列满，不能加入数据！");
        }
        arr[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    public int getQuene() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取出数据！");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void show() {
        int size = size();
        for (int i = front; i < front + size(); i++) {
            System.out.println("arr[" + i % maxSize + "]=" + arr[i % maxSize]);
        }
    }

    public int headQuene() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据！！！");
        }
        return arr[front];
    }

    public int tailQuene() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据！！！");
        }
        return arr[rear - 1];
    }

    public static void main(String[] args) {
        CycleArrayQuene cycleArrayQuene = new CycleArrayQuene(10);
        cycleArrayQuene.addQuene(1);
        cycleArrayQuene.addQuene(2);
        cycleArrayQuene.addQuene(3);
        cycleArrayQuene.addQuene(4);
        cycleArrayQuene.addQuene(5);
        cycleArrayQuene.addQuene(6);
        cycleArrayQuene.addQuene(7);
        cycleArrayQuene.addQuene(8);
        cycleArrayQuene.addQuene(9);
        cycleArrayQuene.getQuene();
        cycleArrayQuene.getQuene();
        cycleArrayQuene.addQuene(10);
        cycleArrayQuene.addQuene(11);
        System.out.println("开始循环遍历");
        cycleArrayQuene.show();
        System.out.println("结束循环遍历");
        System.out.println("头部为：" + cycleArrayQuene.headQuene());
        System.out.println("尾部为：" + cycleArrayQuene.tailQuene());
    }
}
