package Array;

import java.util.HashMap;
import java.util.Map;

public class MaxCountNum {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> distributeMap = new HashMap<>();
        for(int num : nums){
            if(distributeMap.containsKey(num)){
                distributeMap.put(num, distributeMap.get(num) + 1);
            }
            else{
                distributeMap.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : distributeMap.entrySet()){
            if(entry.getValue() > nums.length/2)
                return entry.getKey();
        }

        return -1;
    }
}
