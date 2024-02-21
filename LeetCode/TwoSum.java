package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherPart = target - nums[i];
            if (indices.containsKey(otherPart)) {
                return new int[]{indices.get(otherPart), i};
            } else {
                indices.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
