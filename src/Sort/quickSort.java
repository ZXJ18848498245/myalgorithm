package Sort;
//快速排序
public class quickSort {
    public static void quick(int[] arr,int left,int right){
        int r = right;
        int l =left;
        int temp = 0;
        int pivot = arr[(left+right)/2];
        while (r>l){
            while (r>l && arr[l]<pivot){
                l++;
            }
            while (r>l && arr[r]>pivot){
                r--;
            }
            if (arr[l]==arr[r]&&r>l){
                l++;
            }else{
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        //向左递归
        if (left<r-1){
            quick(arr,left,r-1);
        }
        //向右递归
        if (right>l+1){
            quick(arr,l+1,right);
        }
        for (int a :arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a ={2,5,6,3,2,5,2,4,8,4,9,7};
        quick(a,0,a.length-1);
    }
}
