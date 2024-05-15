package LeetCode;


//URL:https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.Set;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> res = new HashSet<>();
        if (nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            res.add(num);
        }
        int longestSeq = 1;
        for (int num : nums) {
            if (!res.contains(num - 1)) {
                int currentSeq = 1;
                int root = num;
                while (res.contains(root + 1)) {
                    root += 1;
                    currentSeq += 1;
                }
                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }
        return longestSeq;
    }
}
