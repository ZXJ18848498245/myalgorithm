package Array;
//使用数组模拟队列
public class CircleQueue {
    private  int maxSize;
    private int front;//队头
    private int rear;//队尾
    private int[] arr;

    //创建队列的构造器
    public CircleQueue(int arrMaxSize){
        this.maxSize=arrMaxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
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

        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        if (isEmpty()){
            throw new  RuntimeException("队列空，不能取数据");
        }

        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据~");
            return;
        }
        for (int i =front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    //当前队列的有效个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }


    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front];
    }

}
