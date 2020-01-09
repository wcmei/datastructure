package com.wcmei.datastructure;

/**
 * @author wcmei
 * @date 2020-01-09
 * @description
 */
class CycleArrayQuene {
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


        //这里是判断rear是否在预留位置上。也可以用(front-1+maxSize)%maxSize==rear进行判断，
        //预留位置可以理解为(front+队列实际空间)%maxSize的后一个位置,上面的(-1+maxSize)为队列实际空间
//        return (rear + 1) % maxSize == front;
        return (front - 1 + maxSize) % maxSize == rear;
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
        for (int i = front; i <= size(); i++) {
            System.out.println(arr[i]);
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
        CycleArrayQuene cycleArrayQuene = new CycleArrayQuene(3);
        cycleArrayQuene.addQuene(1);
        cycleArrayQuene.addQuene(2);

        System.out.println("大小：" + cycleArrayQuene.size());
        System.out.println(cycleArrayQuene.getQuene());
        System.out.println("大小：" + cycleArrayQuene.size());
        System.out.println("===========================");

        cycleArrayQuene.show();
    }
}
