package Array;

public class ContainerMostWater {
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int window = height.length - 1;
        int l, r;
        while(window > 0){
            for(l = 0, r = l + window; r < height.length; l++, r++){
                max = max > Integer.min(height[l], height[r]) * window ? max
                        : Integer.min(height[l], height[r]) * window;
            }
            window--;
        }
        return max;
    }
}
