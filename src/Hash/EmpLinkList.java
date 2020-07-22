package Hash;

import dao.Emp;

//表示链表
public class EmpLinkList {
    //头指针
     private Emp head;

     //添加雇员到链表
    public void add(Emp emp){
        if (head==null){
            head = emp;
            return;
        }
        Emp curEmp =head;
        while (curEmp.next!=null){
            curEmp=curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no){
        if (head == null){
            System.out.println("第"+(no+1)+"链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"链表的信息为");
        Emp curEmp = head;
        while (true){
            System.out.printf("=>id=%d name=%s\t",curEmp.getId(),curEmp.getName());
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;//后移，遍历
        }
        System.out.println();
    }

    //通过id找到emp
    public Emp findEmpById(int id){
        if (head==null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if (curEmp.getId()==id){
                break;
            }
            if (curEmp.next==null){
                curEmp = null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }
}
