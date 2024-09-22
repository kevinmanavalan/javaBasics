package LeetCode;

//https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

public class KthElementOfTwoSortedArrays {

    public static long binarySearchApproach(int k, int arr1[], int arr2[]){
        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 > n2)
            return binarySearchApproach(k, arr2, arr1);
        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);
        while (low <= high){
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < n1)
                r1 = arr1[mid1];
            if (mid2 < n2)
                r2 = arr2[mid2];
            if (mid1 - 1 >= 0)
                l1 = arr1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = arr2[mid2 - 1];
            if (l1 <= r2 && l2 <= r1)
                return Math.max(l1, l2);
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        return -1;
    }
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int count = 0;
        int a1 = 0, a2 = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        while(a1 < n1 && a2 < n2){
            if(arr1[a1] < arr2[a2]){
                if (count == k - 1){
                    return arr1[a1];
                }
                a1++;
            }
            else{
                if(count == k - 1){
                    return arr2[a2];
                }
                a2++;
            }
            count++;
        }
        while(a1 < n1){
            if (count == k - 1){
                return arr1[a1];
            }
            a1++;
            count++;
        }
        while(a2 < n2){
            if(count == k - 1){
                return arr2[a2];
            }
            a2++;
            count++;
        }
    }
}
