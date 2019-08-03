package ArrayAlogo;

public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        int ret = 0;
        while(N > 0){
            N >>= 1;
            ret++;
        }
        return ret;
    }
}
