package Sort;

import sun.applet.Main;
//希尔排序：交换法
public class shellSort {
    public static void shell(int[] arr){
        int temp =0 ;
        for (int gap = arr.length/2;gap>0;gap = gap/2 ){//设置跨度
            for (int i =gap;i<arr.length;i++){
                //遍历各组所有元素
                for (int j = i-gap;j>=0;j=j-gap){
                    if (arr[j]>arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
        for (int a :arr){
            System.out.print(a+" ");
        }
    }

    public static void main(String[] args) {
            int[] a ={2,5,6,9,2,1,4,5,2,3};
            shell(a);
    }
}
