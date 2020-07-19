package Sort;
//冒泡排序
public class bubbleSort {
    public static void main(String[] args) {
        int[] a ={1,2,5,4,6,3,8,2};
        bubble(a);
    }
    public static void bubble(int[] arr){
        int temp =0;
        for (int i=0;i<arr.length;i++){
            for(int j =0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        for (int a :arr){
            System.out.print(a+" ");
        }
    }
}
