package Array;

import java.util.IdentityHashMap;

//使用数组模拟队列
public class ArrayQueue {
    private  int maxSize;
    private int front;//队头
    private int rear;//队尾
    private int[] arr;

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        this.maxSize=arrMaxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++;//让rear后移
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        if ((isEmpty())){
            throw new  RuntimeException("队列空，不能取数据");
        }
        front++;//front 后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据~");
            return;
        }
        for (int i =0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front++];
    }

}
