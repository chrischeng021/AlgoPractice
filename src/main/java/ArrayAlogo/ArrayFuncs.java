package ArrayAlogo;

import java.util.*;

public class ArrayFuncs {
    public static int[] sortedSquares(int[] A) {
        int middle = 0;

        for(int i = 0; i < A.length; i++){
            if(Math.abs(A[i]) <= Math.abs(A[middle]))
                middle = i;
            else
                break;
        }

        int l = middle - 1;
        int r = middle + 1;
        int index = 0;

        int[] res = new int[A.length];
        res[index++] = (int)Math.pow(A[middle], 2);

        while(index < A.length){
            if(l >= 0 && r < A.length){
                if(Math.abs(A[l]) < A[r]){
                    res[index++] = (int)Math.pow(A[l--], 2);
                }
                else{
                    res[index++] = (int)Math.pow(A[r++], 2);
                }
                continue;
            }
            if(l >= 0)
                res[index++] = (int)Math.pow(A[l--], 2);

            if(r < A.length)
                res[index++] = (int)Math.pow(A[r++], 2);
        }

        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> digitLocationMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            digitLocationMap.computeIfAbsent(nums[i], k -> new ArrayList<>());
            digitLocationMap.get(nums[i]).add(i);
        }
        int[] res = new int[2];
        for(Map.Entry<Integer, List<Integer>> entry : digitLocationMap.entrySet()){
            int curNum = entry.getKey();
            int parNum = target - curNum;
            if(curNum != parNum){
                if(digitLocationMap.get(parNum) != null){
                    res[0] = Math.min(digitLocationMap.get(parNum).get(0), entry.getValue().get(0));
                    res[1] = Math.max(digitLocationMap.get(parNum).get(0), entry.getValue().get(0));
                }
            }
            else{
                if(entry.getValue().size() > 1){
                    res[0] = entry.getValue().get(0);
                    res[1] = entry.getValue().get(1);
                }
            }
        }
        return res;
    }

    public int fixedPoint(int[] A) {
        for(int i = 0; i < A.length; i++){
            if(A[i] == i)
                return i;
        }
        return -1;
    }

    public static int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for(int num : A){
            if(min > num)
                min = num;
        }
        int sum = 0;
        while(min > 0){
            sum += min%10;
            min /= 10;
        }
        return sum % 2 == 0 ? 0 : 1;
    }

    public static int maxSubArray(int[] nums) {
        int resMaxSum = nums[0];
        int curMaxSum = 0;
        for(int num : nums){
            if(curMaxSum > 0)
                curMaxSum += num;
            else
                curMaxSum = num;
            resMaxSum = Math.max(resMaxSum, curMaxSum);
        }
        return resMaxSum;
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        List sortedNums =  Arrays.asList(nums);
//        Collections.sort(sortedNums);
//        List<List<Integer>> res = new ArrayList<>();
//
//        for(int i = 0; i < sortedNums.size(); i++){
//            int curNum = (int)sortedNums.get(i);
//            for(int j = i + 1; j < sortedNums.size(); j++){
//
//            }
//        }
//    }
}
