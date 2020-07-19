package Sort;


//选择排序

public class selectSort {
    public static void main(String[] args) {
        int[] a ={2,6,5,3,4,2,1,5,2,6,8};
        select2(a);
    }
    public static void select1(int[] arr){
        int temp= 0;
        for (int i = 0;i<arr.length;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] =temp;
                }
            }
        }
        for (int a :arr)
             System.out.print(a+" ");
    }

    public static void select2(int[] arr){
        for (int i = 0;i < arr.length;i++){
            int min = arr[i];
            int minidx = i;
            for (int j = i+1 ;j<arr.length;j++){
                if (min>arr[j]){
                    min=arr[j];
                    minidx=j;
                }
            }
            if (min!=arr[i]){
                arr[minidx]=arr[i];
                arr[i]=min;
            }
        }
        for (int a :arr)
            System.out.print(a+" ");
    }
}
