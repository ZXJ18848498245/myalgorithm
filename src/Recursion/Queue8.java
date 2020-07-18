package Recursion;

import java.sql.SQLOutput;
import java.util.Map;

public class Queue8 {

    //定义max表示有多少个皇后
    static int max = 8;
    //定义数组array，保存皇后位置的结果
    static int[] array = new int[max];
    static  int count=0;
    static  int judgeCount = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println("成功次数："+count);
        System.out.println("判断次数："+judgeCount);

    }
    public static void check(int n){
        if (n==8){
            print();
            return;
        }else {
            for (int i =0 ;i< max; i++){
                array[n] = i;
                if (judge(n)){
                    check(n+1);
                }
            }
        }

    }

    public static boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //array[n]==array[i]判断两个皇后是否在一行
            //Math.abs(n-i)==Math.abs(array[n]-array[i])判断相邻两个皇后是不是在一条斜线上
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
    public static void print(){
        count++;
       for (int i = 0 ;i<max;i++)
            System.out.print(array[i]+" ");
        System.out.println();
        }

}

