package LinkedList;

import com.sun.xml.internal.ws.spi.db.FieldSetter;
import dao.Boy;

import java.io.FileReader;

public class CircleSingleLinkedList {

    //创建一个first节点，当前没有编号
    private Boy first = null;

    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums){
        if (nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        for (int i = 1;i<nums;i++){
            Boy boy = new Boy(i);
            //如果第一个小孩
            if (i==1){
                first = boy;
                first.setNext(first); //构成环
                curBoy = first;//让curBoy指向第一个小孩
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy(){
        //判断链表是否为空
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //根据用户输入，计算出小孩出圈的顺序
    //startNo表示从第几个小孩开始数 countNum表示数几下 nums 表示最初有多少小孩在权重

    public void countBoy(int startNo,int countNum,int nums){
        //对数据进行校验
        if (first==null||startNo<1||startNo>nums){
            System.out.println("输入有误");
            return;
        }
        //创建一个辅助指针
        Boy helper = first;
        //helper事先应该指向环形链表的最后这个节点
        while (true){
            if (helper.getNext()==first){
                break;
            }
            helper = helper.getNext();
        }
        //移动到要报数的那个小孩
        for (int j =0;j<startNo-1;j++){
            first=first.getNext();
            helper = helper.getNext();
        }

        //出圈
        while (true){
            if (helper==first){//说明圈中只存在一个点
                break;
            }
            for (int i =0 ;i<countNum-1;i++){ //移动次数
                first =first.getNext();
                helper = helper.getNext();
            }
            //first指的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            first =first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈里的小孩%d",first.getNo());

    }
}
