package LeetCode;

//URL:https://leetcode.com/problems/combination-sum-ii/

import java.util.*;


public class CombinationSum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {     //Not the most efficient solution
        Arrays.sort(candidates);                                                   // T = O(2^n)
        Set<List<Integer>> res = new HashSet<>();                                  // S = extra space for set;
        targetCombinations(0, candidates.length, target, candidates, res, new ArrayList<>());
        return res.stream().toList();

    }

    static void targetCombinations(int index, int n, int target, int[] candidates, Set<List<Integer>> res, List<Integer> combination) {
        if (index == n) {
            if (target == 0) {
                res.add(new ArrayList<>(combination));
            }
            return;
        }
        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            targetCombinations(index + 1, n, target - candidates[index], candidates, res, combination);
            combination.removeLast();
        }
        targetCombinations(index + 1, n, target, candidates, res, combination);
    }





    // Optimal Approach
    public List<List<Integer>> bestApproach(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        bestCombinations(0, candidates.length, target, candidates, res, new ArrayList<>());
        return res;

    }

    static void bestCombinations(int index, int n, int target, int[] candidates, List<List<Integer>> res, List<Integer> combination) {
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i < n; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target >= candidates[i]) {
                combination.add(candidates[i]);
                bestCombinations(i + 1, n, target - candidates[i], candidates, res, combination);
                combination.removeLast();
            }
        }
    }
}
