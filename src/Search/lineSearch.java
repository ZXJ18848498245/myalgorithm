package Search;
//线性查找
public class lineSearch {
    public static int line(int[] arr ,int value){
        for (int i = 0 ;i<arr.length;i++){
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
}
