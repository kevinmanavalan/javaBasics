package LeetCode;

import java.util.ArrayList;
import java.util.List;

//URL:https://leetcode.com/problems/majority-element-ii

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;                                // 👈👈MOORE'S VOTING ALGO Modified
        int count1 = 0;                                    // BEST APPROACH FOR (N/3) MAJORITY
        int count2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (count1 == 0 && el2 != num) {
                el1 = num;
                count1 = 1;
            } else if (count2 == 0 && el1 != num) {
                el2 = num;
                count2 = 1;
            } else if (num == el1) {
                count1++;
            } else if (num == el2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> oneThirds = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == el1) {
                count1++;
            } else if (num == el2) {
                count2++;
            }
        }
        int min = (int) (n / 3) + 1;
        if (count1 >= min)
            oneThirds.add(el1);
        if (count2 >= min)
            oneThirds.add(el2);
        return oneThirds;
    }
}
