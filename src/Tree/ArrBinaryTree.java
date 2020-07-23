package Tree;

public class ArrBinaryTree {
    private int[] arr;//储存数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空");
        }
        //输出当前值
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index*2+1)<arr.length){
            preOrder(index*2+1);
        }
        //向右递归遍历
        if ((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }
}
