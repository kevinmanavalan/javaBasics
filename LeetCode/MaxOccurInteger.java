package LeetCode;

//URL:https://www.geeksforgeeks.org/problems/maximum-occured-integer4602/1

import java.util.HashMap;
import java.util.Map;

public class MaxOccurInteger {
    public static int maxOccured(int n, int[] l, int[] r, int maxx) {      //T = O(length of all ranges summed)
        Map<Integer, Integer> numCount = new HashMap<>();                  //S = O(all the distinct values in all of range)
        for (int rangeIdx = 0; rangeIdx < n; rangeIdx++) {
            for (int i = l[rangeIdx]; i <= r[rangeIdx]; i++) {
                if (numCount.containsKey(i)) {
                    numCount.put(i, numCount.get(i) + 1);
                } else {
                    numCount.put(i, 1);
                }
            }
        }
        int maxOccuringMinVal = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxOccuringMinVal = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                if (entry.getKey() < maxOccuringMinVal) {
                    maxOccuringMinVal = entry.getKey();
                }
            }
        }
        return maxOccuringMinVal;
    }
}
