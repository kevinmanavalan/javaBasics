package LeetCode;

//URL:https://leetcode.com/problems/permutation-sequence/

import java.util.ArrayList;

public class PermutationSequence {
    public String getPermutation(int n, int k) {                    //T = O(N) * O(N)
        int factorial = 1;                                          // N for fetching each of the N numbers
        ArrayList<Integer> numbers = new ArrayList<>();             // of the required sequence.
        StringBuilder res = new StringBuilder();                    // N for removing element from the number list
        for (int i = 1; i < n; i++) {                               // each time a new number in res is found.
            factorial *= i;
            numbers.add(i);                                         //S = O(N)
        }
        numbers.add(n);
        k = k - 1;              // this is done because the numbers in ArrayList are stored with '0' indexing.
        while (true) {
            res.append(numbers.get(k / factorial));
            numbers.remove(k / factorial);
            if (numbers.isEmpty())
                break;
            k = k % factorial;
            factorial = factorial / numbers.size();
        }
        return res.toString();
    }
}
