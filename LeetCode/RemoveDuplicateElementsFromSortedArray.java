package LeetCode;

//URL:https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicateElementsFromSortedArray {
    public int removeDuplicates(int[] nums) {                      //my O(N) approach
        int n = nums.length;
        int left = 0;
        int right = 1;
        while (right < n) {
            if (nums[right] == nums[left]) {
                right++;
            } else {
                left++;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right++;
            }
        }
        return left + 1;
    }

    public int evenBetterApproach(int[] nums) {      // less code
        int n = nums.length;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
