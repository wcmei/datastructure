package com.wcmei.datastructure.linkedlist;

/**
 * @author wcmei
 * @date 2020-02-24
 * @description
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //创建节点
        HeroNode hero1 = new HeroNode(1, "松江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //显示【遍历】
        singleLinkedList.show();

        //测试修改节点的代码
        HeroNode heroNode = new HeroNode(2, "小卢", "玉麒麟");
        singleLinkedList.update(heroNode);

        //测试删除节点的代码
        singleLinkedList.del(3);

        //显示【遍历】
        System.out.println("修改后遍历");
        singleLinkedList.show();

    }
}

class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，所有我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temop后移
            temp = temp.next;
        }
        //退出循环表示temp指向了最后
        //将最后节点的next指向新的节点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //如果有有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助变量（指针）来帮助找到添加的位置
        //因为是单链表，所有我们找的temp是位于添加节点的前一个位置，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//flag标识添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {//不能添加，说明编号存在
            System.out.println("当前编号已存在：" + heroNode.no + "");
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //判断链表是否为空
    public boolean isEmpty() {
        if (head.next == null) {
            return true;
        }
        return false;
    }

    //显示链表【遍历】
    public void show() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode heroNode) {
        //判断是否为空
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.no == heroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = heroNode.name;
            temp.nicknanme = heroNode.nicknanme;
        } else {//没有找到
            System.out.println("没有找到编号为" + heroNode.no + "的节点，不能修改");
        }
    }

    //删除节点
    //思路
    //1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2.说明我们在比较时，是temp.next.no和需要删除的节点no比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp.next == null) {//已经找到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        //判断flag
        if (flag) {//找到
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的" + no + "节点不存在");
        }
    }
}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nicknanme;
    public HeroNode next;

    //构造器
    public HeroNode(int no, String name, String nicknanme) {
        this.no = no;
        this.name = name;
        this.nicknanme = nicknanme;
    }

    //为了显示输出，重写toString
    @Override
    public String toString() {
        return "HeroNode[no=" + no + ",name=" + name + ",nickname=" + nicknanme + "]";
    }
}
