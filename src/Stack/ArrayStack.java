package Stack;

public class ArrayStack {
    private int maxSize;//栈的大小
    private int top ;//表示栈顶
    private int[] stack;//数组，数组模拟栈

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈 - push
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历
    public void list(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i = top ; i >=0; i-- ){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
