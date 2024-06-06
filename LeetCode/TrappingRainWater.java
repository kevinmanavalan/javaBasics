package LeetCode;

//URL:https://leetcode.com/problems/trapping-rain-water

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int juice = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    juice += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    juice += (rightMax - height[right]);
                }
                right--;
            }
        }
        return juice;
    }
}
