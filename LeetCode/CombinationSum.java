package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {                   // PICK OR NOT PICK APPROACH
    public List<List<Integer>> combinationSum(int[] candidates, int target) {          // T = O((2^t) * k)  or just say its exponential
        List<List<Integer>> res = new ArrayList<>();                                   // S = variable
        targetCombinations(0, candidates.length, target, candidates, res, new ArrayList<>());
        return res;
    }

    static void targetCombinations(int index, int n, int target, int[] candidates, List<List<Integer>> res, List<Integer> combination) {
        if (index == n){
            if (target == 0) {
                res.add(new ArrayList<>(combination));
            }
            return;
        }
        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            targetCombinations(index, n, target - candidates[index], candidates, res, combination);
            combination.removeLast();
        }
        targetCombinations(index + 1, n, target, candidates, res, combination);
    }
}
