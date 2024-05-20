package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {              //T = O(N)
        Map<Character, Integer> charMap = new HashMap<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < n){
            if(charMap.containsKey(s.charAt(right))){
                left = Math.max(charMap.get(s.charAt(right)) + 1, left);
            }
            charMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
    public int secondBestApproach(String s) {               //T = O(2N)
        Set<Character> repeatCheck = new HashSet<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < n){
            if(repeatCheck.contains(s.charAt(right))){
                while(left <= right && repeatCheck.contains(s.charAt(right))){
                    repeatCheck.remove(s.charAt(left));
                    left++;
                }
            }
            repeatCheck.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
