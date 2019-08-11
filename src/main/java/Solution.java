import ArrayAlogo.ArrayFuncs;
import DigitalAlgo.DigitalFuncs;
import MultiplyThread.MatrixMultiplier;
import MultiplyThread.ParallelIndividualMultiplier;
import MultiplyThread.SimpleThreadTest;
import StackAlgo.MinStack;
import com.alibaba.fastjson.JSON;
import StringAlgo.StringFuncs;

public class Solution {
    static boolean isPrime(int num){
        if(num < 2)
            return false;
        if(num < 4)
            return true;
        int i = 2;
        int cell = (int)Math.sqrt(num) + 1;
        while(i <= cell){
            if(num % i++ == 0)
                return false;
        }
        return true;
    }

    static int FindNextPrime(int i) {
        while(i < Integer.MAX_VALUE){
            if(isPrime(++i))
                return i;
        }
        return -1;
    }

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

//        for(int i = 0; i < 10; i++){
//            Thread thread = new Thread(new SimpleThreadTest(i));
//            thread.start();
//        }

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

        class TestThread implements Runnable{
            @Override
            public void run(){
                System.out.println(Singleton.getInstance().hashCode());
            }
        }
        int [] testArray = {89,93,84,87,17,4,92,26,99,29,100,85,82,52,76,27,40,69,21,92,89,36};
//        for(int i = 0; i < 10; i++){
//            Thread thread = new Thread(new SimpleThreadTest(10));
//            thread.start();
//        }
    }
}
