package Array;

public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int targetCursor = 0;
        int sourceCursor = 0;
        int movedSteps = 0;
        while(sourceCursor < n){
            int curSourceElement = nums2[sourceCursor];
            while(nums1[targetCursor] < curSourceElement && (targetCursor < (m + movedSteps))){
                targetCursor++;
            }

            movedSteps += moveSubArray(nums1, targetCursor, m + movedSteps - targetCursor, 1);
            nums1[targetCursor] = curSourceElement;
            sourceCursor++;
            targetCursor++;
        }
    }

    // 将数组从start开始的count个值向右移动step个位置
    private int moveSubArray(int[] nums, int start, int count, int step){
        if(start < 0 || count <= 0)
            return 0;
        for(int i = start + count - 1; i >= start; i--){
            nums[i+step] = nums[i];
        }
        return 1;
    }
}
