package streamsWork;

import java.util.HashMap;
import java.util.Map;

//TWO SUM USING HASHMAP


public class Streams8 {
    public static void main(String args[]) {
        int arr[] = new int[]{4, 3, 5, 2, 5, 6, 2, 6, 8, 1, 9};
        int target = 10;
        for (int i : twoSum(arr, target)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{i, numMap.get(target - nums[i])};
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
