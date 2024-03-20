package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ListAllPermutation {
    public List<List<Integer>> listAllPermutation(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        recurPermute(nums, 0, permutations);
        System.out.println(permutations);
        return permutations;
    }

    public void recurPermute(int[] nums, int index, List<List<Integer>> permutations) {
        if (index == nums.length) {
            List<Integer> order = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                order.add(nums[i]);
            }
            permutations.add(order);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(nums, index + 1, permutations);
            swap(i, index, nums);
        }
    }

    public void swap(int i, int index, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    public static void main(String args[]) {
        ListAllPermutation obj = new ListAllPermutation();
        obj.listAllPermutation(new int[]{1, 3, 2});
    }

}
