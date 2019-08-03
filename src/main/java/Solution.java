import ArrayAlogo.ArrayFuncs;
import com.alibaba.fastjson.JSON;
import StringAlgo.StringFuncs;

public class Solution {
    public static void main(String [] args){
        ArrayFuncs arrayFuncs = new ArrayFuncs();
        int[] testArray = {2, 5, 5, 11};

        System.out.println(JSON.toJSONString(ArrayFuncs.twoSum(testArray, 10)));
    }
}
