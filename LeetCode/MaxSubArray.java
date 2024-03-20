package LeetCode;

// Total 3 approaches 👇👇👇👇

public class MaxSubArray {
    public int maxSubArray(int[] nums) {   //Dynamic approach
        int maxSumAtEachPoint[] = new int[nums.length];
        int absoluteMax = nums[0];
        maxSumAtEachPoint[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSumAtEachPoint[i] = Math.max(maxSumAtEachPoint[i - 1] + nums[i], nums[i]);
            if (maxSumAtEachPoint[i] > absoluteMax) {
                absoluteMax = maxSumAtEachPoint[i];
            }
        }
        return absoluteMax;
    }

    public int approach2(int[] nums) { //kadane's algorithm
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public int approach3(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }
}
