package LeetCode;

//URL:https://leetcode.com/problems/subsets-ii/

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class SubSetsWithDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {          // My solution T =
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        subSets(0, nums.length, nums, res, new ArrayList<>());
        return res.stream().toList();
    }
    static void subSets(int i, int n, int[] nums, Set<List<Integer>> res, List<Integer> subSet){
        if(i == n){
            res.add(new ArrayList<>(subSet));
            return;
        }
        subSet.add(nums[i]);
        subSets(i + 1, n, nums, res, subSet);
        subSet.removeLast();
        subSets(i + 1, n, nums, res, subSet);
    }


    //Optimal approach
    public List<List<Integer>> bestApproach(int[] nums) {               //T  = O(
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        optimalSubSets(0, nums.length, nums, res, new ArrayList<>());
        return res;
    }
    static void optimalSubSets(int index, int n, int[] nums, List<List<Integer>> res, List<Integer> subSet){
        res.add(new ArrayList<>(subSet));
        for(int i = index; i < n; i++){
            if(i != index && nums[i] == nums[i-1])
                continue;
            subSet.add(nums[i]);
            optimalSubSets(i + 1, n, nums, res, subSet);
            subSet.removeLast();
        }
    }
}
