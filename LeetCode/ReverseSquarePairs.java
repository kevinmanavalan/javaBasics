package LeetCode;

import java.util.ArrayList;

//URL:https://leetcode.com/problems/reverse-pairs

public class ReverseSquarePairs {                               //HARD PROBLEM
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length-1, nums);
    }

    public int mergeSort(int low, int high, int[] nums) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (high - low) / 2 + low;
        count += mergeSort(low, mid, nums);
        count += mergeSort(mid + 1, high, nums);
        count += reversePairs(low, mid, high, nums);
        merge(low, mid, high, nums);
        return count;
    }

    public void merge(int low, int mid, int high, int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }
        while (left <= mid) {
            temp.add(nums[left++]);
        }
        while (right <= high) {
            temp.add(nums[right++]);
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public int reversePairs(int low, int mid, int high, int[] nums) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > (long)2 * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }
}
