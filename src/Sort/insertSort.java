package Sort;
//插入排序，把数组分为两个序列，前面为有序序列，后面为无序
public class insertSort {
    public static void main(String[] args) {
        int[] a ={1,2,5,4,6,3,8,2};
        insert2(a);
    }
    public static void insert1(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int value = arr[i];//要插入的值
            int index = i-1;//有序队列的最后一个下标
            while (index>=0&&value<arr[index]){
                arr[index+1]=arr[index];
                index--;
            }
            if (index+1!=i){//判断时候交换
                arr[index+1]=value;
            }
        }
        for (int a :arr){
            System.out.print(a+" ");
        }
    }

    public static void insert2(int[] arr){
        int temp;
        for (int i = 0;i<arr.length;i++){
            for (int j=i-1;(j>=0&&arr[j+1]<arr[j]);j--){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1]=temp;
            }
        }
        for (int a :arr){
            System.out.print(a+" ");
        }
    }
}
