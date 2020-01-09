package com.wcmei.datastructure;

/**
 * @author wcmei
 * @date 2020-01-09
 * @description
 */
//数组队列
class ArrayQuene {
    private int[] arr;
    private int maxSize;
    private int front;
    private int rear;

    public ArrayQuene(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQuene(int element) {
        if (isFull()) {
            throw new RuntimeException("队列满，不能加入数据！");
        }
        arr[++rear] = element;
    }

    public int getQuene() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取出数据！");
        }
        return arr[++front];
    }

    public void show() {
    }

    public int headQuene() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据！！！");
        }
        return arr[front + 1];
    }

    public int tailQuene() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据！！！");
        }
        return arr[rear];
    }

    public static void main(String[] args) {
        ArrayQuene arrayQuene = new ArrayQuene(3);
        arrayQuene.addQuene(1);
        arrayQuene.addQuene(2);
        arrayQuene.addQuene(3);
        arrayQuene.show();
        System.out.println(arrayQuene.headQuene());
        System.out.println(arrayQuene.tailQuene());
    }
}
