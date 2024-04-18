package LeetCode;

//URL:https://leetcode.com/problems/majority-element/

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {             // 👈👈MOORE'S VOTING ALGO
        int n = nums.length;                             // BEST APPROACH FOR (N/2) MAJORITY
        int count = 0;
        int el = nums[0];
        for (int num : nums) {
            if (count == 0) {
                count = 1;
                el = num;
            } else if (num == el) {
                count++;
            } else {
                count--;
            }
        }
        int count1 = 0;
        for (int num : nums) {
            if (num == el) count1++;
        }
        return count1 > (n / 2) ? el : -1;
    }

    public int Approach2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();    //HASHING EACH VALUE USING A MAP
        for (int num : nums) {
            int count = 0;
            if (countMap.containsKey(num)) {
                count = countMap.get(num);
                countMap.put(num, ++count);
            } else {
                count = 1;
                countMap.put(num, count);
            }
            if (count > (n / 2))
                return num;
        }
        return -1;
    }
}
