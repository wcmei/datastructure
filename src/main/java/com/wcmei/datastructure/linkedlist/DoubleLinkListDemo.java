package com.wcmei.datastructure.linkedlist;

/**
 * @author wcmei
 * @date 2020-02-24
 * @description
 */
public class DoubleLinkListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");

        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "松江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个双向链表
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.add(hero1);
        doubleLinkList.add(hero2);
        doubleLinkList.add(hero3);
        doubleLinkList.add(hero4);

        //显示【遍历】
        doubleLinkList.show();

        //修改
        HeroNode2 heroNode = new HeroNode2(2, "小卢", "玉麒麟");
        doubleLinkList.update(heroNode);

        //删除
        doubleLinkList.del(3);

        //修改后遍历
        System.out.println("修改后遍历");
        doubleLinkList.show();

    }

}

//创建一个双向链表的类
class DoubleLinkList {

    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
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
        HeroNode2 temp = head.next;
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

    //添加一个节点到双向链表的最后
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，所有我们需要一个辅助变量temp
        HeroNode2 temp = head;
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
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改一个节点的内容，可以看到双向链表的节点内容修改和单项链表一样
    //只是节点类型改成HeroNode2
    public void update(HeroNode2 heroNode) {
        //判断是否为空
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
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

    //从双向链表中删除一个节点
    //说明
    //1.对于双向链表，我们可以直接找到要删除的这个节点
    //2.找到后，自我删除即可
    public void del(int no) {

        //判断当前链表是否为空
        if (isEmpty()) {
            System.out.println("当前链表为空，不能删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp == null) {//已经找到链表的最后
                break;
            }
            if (temp.no == no) {
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        //判断flag
        if (flag) {//找到
            //可以删除
            //temp.next = temp.next.next;[单项链表]
            temp.pre.next = temp.next;
            //这里我们的代码有问题？
            //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("要删除的" + no + "节点不存在");
        }
    }
}

//定义HeroNode2，每个HeroNode对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nicknanme;
    public HeroNode2 next;//指向下一个节点，默认为null
    public HeroNode2 pre;//指定前一个节点，默认为null

    //构造器
    public HeroNode2(int no, String name, String nicknanme) {
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
