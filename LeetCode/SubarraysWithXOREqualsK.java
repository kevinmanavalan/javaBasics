package LeetCode;

import java.util.Map;
import java.util.HashMap;


//URL:https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/

public class SubarraysWithXOREqualsK {
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        int n = a.length;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        sumMap.put(sum, 1);
        int count = 0;
        for(int i = 0; i < n; i++){
            sum = sum ^ a[i];
            int prefix = sum ^ b;
            if(sumMap.containsKey(prefix)){
                count += sumMap.get(prefix);
            }
            if(sumMap.containsKey(sum)){
                int value = sumMap.get(sum);
                sumMap.put(sum, ++value);
            }
            else{
                sumMap.put(sum, 1);
            }
        }
        return count;
    }
}
