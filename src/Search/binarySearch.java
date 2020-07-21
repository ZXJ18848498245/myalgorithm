package Search;

import java.util.ArrayList;
//二分查找，前提是有序数列
public class binarySearch {
    public static int binary(int[] arr,int left,int right,int value){
        if (left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midValue=arr[mid];

        if (value>midValue){
            return binary(arr,mid+1,right,value);
        }else if(value<midValue){
            return binary(arr,left,mid,value);
        }else{
            return mid;
        }

    }
    public static ArrayList<Integer> binary2(int[] arr, int left, int right, int value){
        if (left>right){
            return new ArrayList<>();
        }
        int mid = (left+right)/2;
        int midValue=arr[mid];

        if (value>midValue){
            return binary2(arr,mid+1,right,value);
        }else if(value<midValue){
            return binary2(arr,left,mid-1,value);
        }else{
            ArrayList<Integer> index = new ArrayList<>();

            int temp = mid-1;
            while (true){
                if (temp<0||arr[temp]!=value){
                    break;
                }
                index.add(temp);
                temp--;

            }
            index.add(mid);
            temp = mid+1;
            while (true){
                if (temp> arr.length-1||arr[temp]!=value){
                    break;
                }
                index.add(temp);
                temp++;
            }
            return index;
        }

    }


    public static void main(String[] args) {
        int[] a ={1,3,5,6,6,6,8,9,12};
        ArrayList<Integer> b = binary2(a,0,a.length-1,6);
       // System.out.println(b);
        for (Integer b1:b){
            System.out.print(b1+" ");
        }

    }
}
