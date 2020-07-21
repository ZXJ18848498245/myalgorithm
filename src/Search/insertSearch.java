package Search;
//插值查询是在二分查询的基础上，每次从mid自适应开始查找，插值
//mid = left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
public class insertSearch {
    public static int insert(int[] arr,int left,int right,int value){
        if (left>right||arr[0]>value||arr[arr.length-1]<value){
            return -1;
        }
        int mid = left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
        if (arr[mid]>value){
            return insert(arr,left,mid,value);
        }else if (arr[mid]<value){
            return insert(arr,mid+1,right,value);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a= {2,5,6,8,9,65,254};
        System.out.println(insert(a,0,a.length-1,8));
    }
}
