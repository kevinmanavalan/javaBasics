package LeetCode;

//URL:https://www.geeksforgeeks.org/problems/subset-sums2234/1

import java.util.ArrayList;

public class SubSetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {        //T = O(2^n)
        ArrayList<Integer> res = new ArrayList<>();                       //S = O(2^n)
        sequences(0, arr, n, res, 0);
        return res;
    }
    static void sequences(int i , ArrayList<Integer> arr, int n, ArrayList<Integer> res, int sum){
        if(i == n){
            res.add(sum);
            return;
        }
        sequences(i + 1, arr, n, res, sum + arr.get(i));
        sequences(i + 1, arr, n, res, sum);
    }

}
