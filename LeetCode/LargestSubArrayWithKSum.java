package LeetCode;


//  Example:       {1,2,4,6,4,3,2,4,6,7,5,3,1,3,4,2,1,1,1,2,3,4,2}       target k = 3       so    {1, 1, 1} is the answer

import java.util.Map;
import java.util.HashMap;

public class LargestSubArrayWithKSum {
    public int positiveAndNegativeArray(int[] arr, int k){      // array including -ve's +ve's and zero's
        Map<Long, Integer> sumSet = new HashMap<>();
        int n = arr.length;
        long sum = 0;
        int maxLength = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == k){
                maxLength = Math.max(maxLength, i + 1);
            }
            long prefixSum = sum - k;
            if(sumSet.containsKey(prefixSum)){
                int length = i - sumSet.get(prefixSum);
                maxLength = Math.max(maxLength, length);
            }
            if(!sumSet.containsKey(sum)){                 //because zero's and -ve's will mess up the code
                sumSet.put(sum, i);                       //
            }                                             //
        }
        return maxLength;
    }
    public int onlyPositiveIntegerArray(int[] a, int k){      // array containing only +ve's and zero's
        int left = 0;
        int n = a.length;
        int right = 0;
        long sum = a[0];
        int maxLength = 0;
        while(right  < n){
            while(left < right && sum > k){
                sum -= a[left];
                left++;
            }
            if(sum == k){
                maxLength = Math.max(maxLength, (right - left + 1));
            }
            right++;
            if(right < n)
                sum+= a[right];
        }
        return maxLength;
    }
}
