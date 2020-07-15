package Array;

import java.awt.*;

public class sparseArray {
    public static void main(String[] args) {
        //创建一个原始数组11*11
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 5;

        //输出原始的二维数组
        System.out.println("原始二维数组---");
        for (int[] row :chessArr1){
            for (int data :row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组 转换维 稀疏数组
        int sum =0;
        for (int i =0;i<chessArr1.length;i++)
            for (int j =0;j<chessArr1[i].length;j++){
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }

        //创建对应的稀疏数组
        int[][] sparseArr =  new int[sum+1][3];
            sparseArr[0][0] = chessArr1.length;
            sparseArr[0][1] = chessArr1[1].length;
            sparseArr[0][2] = sum;

            //遍历二维数组，将非0值存入到sparseArr中
        int count = 0;
        for (int i = 0;i<chessArr1.length;i++)
            for (int j =0;j<chessArr1[i].length;j++){
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }

        //输出稀疏数组形式
        System.out.println("稀疏数组");
        for (int i=0 ;i<sparseArr.length;i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }

        //稀疏数组 转化为 二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
         for (int i =1;i<sparseArr.length;i++){
             chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
         }

         //输出恢复的二维数组
        System.out.println("恢复后的二维数组");
         for (int[] row : chessArr2) {
             for (int data : row) {
                 System.out.printf("%d\t", data);
             }
             System.out.println();
         }
    }
}
