package LinkedList;

import dao.HeroNode2;

public class DoubleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2('0', " ", "");

    //方法一：添加节点到单向链表
    //思路：当不考虑编号顺序时
    //1.找到当前链表的最后节点 2.将最后这个节点的next指向新的节点
    public void add(HeroNode2 heroNode){

        //因为head节点不能动，因此我们需要一个辅助便利temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre=temp;

    }

    //方法二：添加英雄时，根据排名将英雄插入到指定位置
    //如果有这个排名，则添加失败
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = head;
        boolean flag = false; //flag标志添加的编号是否存在
        while (true){
            if (temp.next==null){
                break;//说明temp已经在链表的最后
            }
            if (temp.next.getNo()>heroNode.getNo()){
                break;//位置找到，就在temp的后面插入
            }else if (temp.next.getNo()==heroNode.getNo()){
                flag=true;//说明要查找的编号已经存在
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag){
            System.out.printf("准备插入的英雄的编号%d已经存在\n",heroNode.getNo());
        }else{
            //插入节点
            heroNode.next = temp.next;
            temp.next.pre=heroNode;
            heroNode.pre = temp;
            temp.next = heroNode;
        }
    }
    //修改节点信息，根据no编号修改，即no编号不能该
    public void update(HeroNode2 heroNode){
        if (head.next==null){
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true){
            if (temp==null){
                break;//已经遍历链表
            }
            if (temp.getNo()==heroNode.getNo()){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断节点是否找到
        if (flag){
            temp.setName(heroNode.getName());
            temp.setNickname(heroNode.getNickname());
        }else {
            System.out.println("没有找到该节点~");
        }
    }
    //删除节点
    //通过no确定删除
    public void del(int no){
        HeroNode2 temp = head.next;
        boolean flag = false;//标志是否找到待删除的节点
        while (true){
            if (temp==null){
                break;//已经到链表的最后
            }
            if (temp.getNo()==no){
                flag = true;
                break;
            }
            temp=temp.next;
        }
        //判断flag
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next!=null)
                temp.next.pre = temp.pre;
        }else {
            System.out.println("节点不存在");
        }
    }
    //显示链表
    public void list(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);

            temp=temp.next;
        }
    }
}