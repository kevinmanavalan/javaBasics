package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public void nextPermutation(List<Integer> nums) {
        int n = nums.size();
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Collections.reverse(nums);
            System.out.println(nums);
            return;
        } else {
            for (int i = n - 1; i > index; i--) {
                if (nums.get(i) > nums.get(index)) {
                    int temp = nums.get(index);
                    nums.set(index, nums.get(i));
                    nums.set(i, temp);
                    break;
                }
            }
            List<Integer> subList = nums.subList(index + 1, n);
            Collections.reverse(subList);
            System.out.println(nums);
        }


    }

    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public static void main(String args[]) {
        NextPermutation obj = new NextPermutation();
        obj.nextPermutation(Arrays.asList(1, 3, 2));
    }
}
