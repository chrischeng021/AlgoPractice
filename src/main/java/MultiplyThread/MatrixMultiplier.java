package MultiplyThread;

import com.alibaba.fastjson.JSON;

import java.util.Random;

public class MatrixMultiplier {
    static class MatrixGenerator{
        public static int[][] generate (int rows, int columns) {
            int[][] ret=new int[rows][columns];
            Random random=new Random();
            for (int i=0; i<rows; i++) {
                for (int j=0; j<columns; j++) {
                    ret[i][j]=(int)(random.nextDouble()*100);
                } }
            return ret; }
    }

    public static int[][] generateRandomMatrix(int rows, int columns){
        return MatrixGenerator.generate(rows, columns);
    }

    public static void printMatrix(int [][] matrix){
        for(int i = 0; i < matrix.length; i++){
            System.out.println(JSON.toJSONString(matrix[i]));
        }
        System.out.println("\n\n\n\n");
    }

    public static void multiply (int[][] matrix1, int[][] matrix2, int[][] result) {
        long startTime = System.currentTimeMillis();
        int rows1=matrix1.length;
        int columns1=matrix1[0].length;
        int columns2=matrix2[0].length;
        for (int i=0; i<rows1; i++) {
            for (int j=0; j<columns2; j++) {
                result[i][j]=0;
                for (int k=0; k<columns1; k++) {
                    result[i][j]+=matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
