package Sort;

import org.omg.CORBA.ARG_OUT;

//归并排序。分治算法，先分后治
public class mergeSort {
    public static void main(String[] args) {
        int[] a = {8,4,5,7,1,3,6,2};
        int[] t = new int[a.length];
        mergesort(a,0,a.length-1, t);
        for (int a1: a){
            System.out.print(a1+" ");
        }
       /* String b =new String();
        String a1=b;
        String a2=b;
        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));*/
    }
    public static void mergesort(int[] arr,int left,int right,int[] temp){
        if(left<right) {
            int mid = (left + right) / 2;
            //先递归，分
            mergesort(arr, left, mid, temp);
            mergesort(arr, mid + 1, right, temp);
            //后并，治
            merge(arr, left, mid, right, temp);
        }
    }
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int l =left;
        int r =mid+1;
        int t = 0;
        //左右两边比较，放入temp
        while (l<=mid && r<=right){
            if (arr[l]<arr[r]){
                temp[t]=arr[l];
                t=t+1;
                l=l+1;
            }else{
                temp[t]=arr[r];
                t=t+1;
                r=r+1;
            }
        }
        //将左边剩下的放到temp
        while (l<=mid){
            temp[t] = arr[l];
            t=t+1;
            l=l+1;
        }
        //将右边剩下的放到temp
        while (r<=right){
            temp[t]= arr[r];
            t=t+1;
            r=r+1;
        }
        t =0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t=t+1;
            tempLeft=tempLeft+1;
        }



    }
}
