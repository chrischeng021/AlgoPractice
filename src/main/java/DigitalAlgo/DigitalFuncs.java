package DigitalAlgo;

public class DigitalFuncs {
    public static int mySqrt(int x) {
        if(x < 2)
            return x;
        int res = 1;
        while(true){
            if(res * res <= x){
                System.out.println(res);
                System.out.println(res * res);
                res++;
            }
            else{
                break;
            }
        }
        System.out.println(Integer.MAX_VALUE);
        return res - 1;
    }
}
