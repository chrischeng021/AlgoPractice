package DigitalAlgo;

public class Tribonacci {
    // 说明：使用了递归的版本在实际测试中栈溢出
    // 因此，只能考虑使用非递归版本
//    public int tribonacci(int n) {
//        switch(n){
//            case 0:
//                return 0;
//            case 1:
//                return 1;
//            case 2:
//                return 1;
//            default:
//                return tribonacci(n) + tribonacci(n-1) + tribonacci(n-2);
//        }
//    }

    public int tribonacci(int n){
        int[] res = new int[n + 3];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;

        if(n < 3)
            return res[n];

        for(int i = 3; i <= n; i++){
            res[i] = res[i-3] + res[i-2] +res[i-1];
        }

        return res[n];
    }
}
