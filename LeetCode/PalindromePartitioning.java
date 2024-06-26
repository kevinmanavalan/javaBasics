package LeetCode;

//URL:https://leetcode.com/problems/palindrome-partitioning/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {                                      //T = O( (2^n) * k * (n/2) )
    public List<List<String>> partition(String s) {                        // *k is the average length of a palindrome
        List<List<String>> res = new ArrayList<>();
        palindromes(0, s.length(), s, res, new ArrayList<>());       //S = O(k * x)
        return res;                                                        // *x is the total number of substring lists
    }                                                                      // *k is the avg length of a substring list
    static void palindromes(int index, int n, String s, List<List<String>> res, List<String> partitions){
        if(index == n){
            res.add(new ArrayList<>(partitions));
            return;
        }
        for(int i = index; i < n; i++){
            if(isPalindrome(s.substring(index, i + 1))){
                partitions.add(s.substring(index, i + 1));
                palindromes(i + 1, n, s, res, partitions);
                partitions.removeLast();
            }
        }

    }
    static boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
