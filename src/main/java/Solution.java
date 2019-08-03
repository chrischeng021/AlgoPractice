import ArrayAlogo.ArrayFuncs;
import MultiplyThread.MatrixMultiplier;
import MultiplyThread.ParallelIndividualMultiplier;
import MultiplyThread.SimpleThreadTest;
import com.alibaba.fastjson.JSON;
import StringAlgo.StringFuncs;

public class Solution {
    public static void main(String [] args){
        //基础版本 直接开启十个线程打印
//        for(int i = 0; i < 10; i++){
//            Thread thread = new Thread(new SimpleThreadTest(i));
//            thread.start();
//        }

        //强制串行化
//        try{
//            for(int i = 0; i < 10; i++){
//                Thread thread = new Thread(new SimpleThreadTest(i));
//                thread.start();
//                thread.join();
//            }
//        }
//        catch(InterruptedException e){
//
//        }

        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new SimpleThreadTest(i));
            thread.start();
        }

//        int rows = 2000;
//        int cols = 2000;
//        int[][] preMatrix = MatrixMultiplier.generateRandomMatrix(rows, cols);
//        int[][] nxtMatrix = MatrixMultiplier.generateRandomMatrix(rows, cols);
//
//        int[][] resMatrix = new int[rows][cols];

        //串行程序运行时间：57151ms
        //MatrixMultiplier.multiply(preMatrix, nxtMatrix, resMatrix);
        //MatrixMultiplier.printMatrix(resMatrix);

        //并发程序运行时间：335228ms
        //ParallelIndividualMultiplier.multiply(preMatrix, nxtMatrix, resMatrix);
    }
}
