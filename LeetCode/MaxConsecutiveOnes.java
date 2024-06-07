package LeetCode;

//URL:https://leetcode.com/problems/max-consecutive-ones/

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxConsec = 0;
        int currentConsec = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                currentConsec++;
                maxConsec = Math.max(currentConsec, maxConsec);
            } else {
                currentConsec = 0;
            }
        }
        return maxConsec;
    }
}
