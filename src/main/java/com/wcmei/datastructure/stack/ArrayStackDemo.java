package com.wcmei.datastructure.stack;

import javax.swing.plaf.basic.BasicLabelUI;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wcmei
 * @date 2020-03-06
 * @description
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        //测试
        //创建栈，ArrayStack对象
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：表示添加数据到栈（入栈）");
            System.out.println("pop：表示从栈取出数据（出栈）");
            System.out.println("请输入你的选择");
            key = scanner.next();

            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int res = stack.pop();
                    try {
                        System.out.println("出栈的数据是：" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出了");

    }
}

//定义一个ArrayStack,表示栈
class ArrayStack {

    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就放在该数组
    private int top = -1;//top表示栈顶，初始为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        return stack[top--];
    }

    //显示栈的情况【遍历栈】
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "]=" + stack[i]);
        }
    }

}
