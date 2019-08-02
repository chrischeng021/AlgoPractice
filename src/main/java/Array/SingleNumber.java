package Array;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int candidate = 0;

        for(int num :  nums){
            candidate = candidate ^ num;
        }
        return candidate;
    }
}
