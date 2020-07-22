package Hash;

import dao.Emp;

//管理链表
public class HashTable {
    private EmpLinkList[] empLinkListArray;
    //链表数量
    private int size;

    //构造器
    public HashTable(int size){
        this.size = size;
        empLinkListArray = new EmpLinkList[size];
        //初始化每个链表
        for (int i =0;i<size;i++){
            empLinkListArray[i] = new EmpLinkList();
        }
    }
    //添加雇员
    public void add(Emp emp){
        int emplinkListNo = hashFun(emp.getId());
        //将emp添加到数组中
        empLinkListArray[emplinkListNo].add(emp);
    }
    //遍历所有的链表
    public void list(){
        for (int i = 0;i<size;i++){
            empLinkListArray[i].list(i);
        }
    }
    //根据输入的id，找雇员
    public void findEmpById(int id){
        //使用散列函数确定那条链表要查
        int empLinkListNo=hashFun(id);
        Emp emp = empLinkListArray[empLinkListNo].findEmpById(id);
        if (emp != null){
            System.out.printf("在第%d条链表找到 雇员 id = %d\n",empLinkListNo,id);
        }else
            System.out.println("在哈希表中，没有找到该雇员~");
        /*for (int i =0 ;i<size;i++){
            if (empLinkListArray[i].findEmpById(id).getId()==id){
                return empLinkListArray[i].findEmpById(id);
            }
        }
        return null;*/
    }
    //散列函数
    public int hashFun(int id){
        return id%size;
    }
}
