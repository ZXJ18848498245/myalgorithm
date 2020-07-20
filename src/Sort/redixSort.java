package Sort;
//基数排序，堆排序
public class redixSort {
    public static void redix(int[] arr){
        //找到最大值的长度
        int max = arr[0];
        for (int i = 0;i<arr.length;i++){
            if (arr[i]>max)
                max = arr[i];
        }
        int len = (max+" ").length();

        //定义一个二维数组做桶
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中加入的数
        int[] bucketCount = new int[arr.length];

        for (int i = 0,n = 1;i < len;i++,n=n*10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketCount[digitOfElement]] = arr[j];
                bucketCount[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketCount.length; k++) {
                for (int l = 0; l < bucketCount[k]; l++) {
                    if (bucketCount[k]!=0)
                    arr[index++] = bucket[k][l];
                }
                bucketCount[k]=0;
            }
        }

        for (int a :arr){
            System.out.print(a+" ");
        }
    }

    public static void main(String[] args) {
        int[] a ={2,3,5,8,9,6,5,4,1,2,3};
        redix(a);
    }
}
