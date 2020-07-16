package LinkedList;

import dao.HeroNode;
//单向链表反转
public class SingleLinkedListreverse {
    public static void reserseList(HeroNode head){
        //判断链表是否为空，或者只有一个节点
        if (head.next==null||head.next.next==null){
            return;
        }

        //
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0," "," ");

        while (temp!=null){
            next = temp.next;//先存一下，后面指向变了
            temp.next = reverseHead.next;//将temp的下一个节点指向新的链表的最前端
            reverseHead.next = temp;//将temp连接到新的链表上
            temp = next;
        }
        head.next = reverseHead.next;

    }
}
