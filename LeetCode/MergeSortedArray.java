package LeetCode;

public class MergeSortedArray {

    //URL:/problems/merge-sorted-array
    public void merge(int[] nums1, int m, int[] nums2, int n) { // Approach 1
        int[] res = new int[nums1.length];
        int i = 0, j = 0, idx = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[idx++] = nums1[i++];
            } else {
                res[idx++] = nums2[j++];
            }
        }
        while (i < m) {
            res[idx++] = nums1[i++];
        }
        while (j < n) {
            res[idx++] = nums2[j++];
        }
        idx = 0;
        while (idx < nums1.length) {
            nums1[idx] = res[idx];
            idx++;
        }
    }

    public void approach2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
