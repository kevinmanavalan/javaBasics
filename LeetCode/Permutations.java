package LeetCode;

//URL:https://leetcode.com/problems/permutations/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutations(0, nums, res);
        return res;
    }

    static void permutations(int index, int[] nums, List<List<Integer>> res){
        if(index == nums.length){
            res.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        for(int i = nums.length - 1; i >= index; i--){
            swap(nums, i, index);
            permutations(index + 1, nums, res);
            swap(nums, i, index);
        }
    }
    static void swap(int[] nums, int i, int index){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
