package Search;

import java.util.Arrays;
//斐波那契查找，通过斐波那契数列，找中值
public class fibSearch {
    private static  int maxSize=50;
    //获取斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i =2;i<maxSize;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }

    public static int fibsearch(int[] arr,int value){
        int low =0;
        int high = arr.length-1;
        int k =0;
        int mid = 0;
        int f[] =fib();//获取斐波那契数列
        //获得分割数的下标
        while (high>f[k]-1){
            k++;
        }
        int[] temp= Arrays.copyOf(arr,f[k]);
        //arr数组的长度可能小于f[k]的值，用后面的值用最大值填充
        for(int i =high+1;i<f[k];i++){
            temp[i] = arr[high];
        }

        while (low<=high){
            //通过斐波那契数列找黄金分割点
            mid = low+f[k-1]-1;
            if (value<temp[mid]){
                high=mid-1;
                //f[k] = f[k-1] + f[k-2],位于左半段时,下次判定mid时k应该-1
                k--;
            }else if (value>temp[mid]){
                low = mid+1;
                //f[k] = f[k-1] + f[k-2],位于右半段时,下次判定mid时k应该-2
                k=k-2;
            }else {
                if (mid<=high){
                    return mid;
                }else {
                    //当mid位于扩容的数组中时，返回最大值
                    return high;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 1,5,6,9,63,96,154,254};
        System.out.println(fibsearch(a,63));
    }
}
