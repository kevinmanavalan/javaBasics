package LeetCode;


//URL:/problems/sort-colors/

public class SortThreeNumbers {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeroIndex = 0;
        int twoIndex = n - 1;
        int i = 0;
        while (i <= twoIndex) {
            if (nums[i] == 0) {
                swap(i, zeroIndex, nums);
                zeroIndex++;
                i++;
            } else if (nums[i] == 2) {
                swap(i, twoIndex, nums);
                twoIndex--;
            } else if (nums[i] == 1) {
                i++;
            }
        }
    }

    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        SortThreeNumbers sortThreeNumbers = new SortThreeNumbers();
        sortThreeNumbers.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
