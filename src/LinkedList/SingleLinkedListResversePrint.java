package LinkedList;

import dao.HeroNode;

import java.util.Stack;
//链表从后向前打印
public class SingleLinkedListResversePrint {
    public static void resversePrint(HeroNode head){
        if (head.next==null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode temp = head.next;
        //将链表的所有的节点压入栈
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }

        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
