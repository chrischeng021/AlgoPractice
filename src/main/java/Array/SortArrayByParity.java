package Array;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int [] ret = new int[A.length];
        int l = 0;
        int r = A.length - 1;
        for(int i : A){
            if(A[i] % 2 == 0){
                ret[l++] = i;
            }
            else{
                ret[r--] = i;
            }
        }
        return ret;
    }
}
