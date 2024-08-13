package LeetCode;

//URL:https://leetcode.com/problems/single-element-in-a-sorted-array/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {            //using HashMap
        HashMap<Integer, Integer> numMap = new HashMap<>();
        Arrays.stream(nums).forEach(num -> numMap.put(num, numMap.getOrDefault(num, 0) + 1));
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    public static int optimalApproach(int[] nums){
        int n = nums.length;
        if(nums.length == 1)
            return nums[0];
        else if(nums[0] != nums[1])
            return nums[0];
        else if(nums[n-1] != nums[n-2])
            return nums[n-1];
        int left = 0;
        int right = nums.length;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            else if((nums[mid] == nums[mid - 1] && mid % 2 == 1) || (nums[mid] == nums[mid + 1] && mid % 2 == 0))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
