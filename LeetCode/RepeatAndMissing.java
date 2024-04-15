package LeetCode;

import java.util.*;

//URL:https://www.interviewbit.com/problems/repeat-and-missing-number-array/

public class RepeatAndMissing {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long n = A.size();
        long sn = n * (n + 1) / 2;
        long s2n = n * (n + 1) * ((2 * n) + 1) / 6;
        long s = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s += A.get(i);
            s2 += (long) A.get(i) * (long) A.get(i);
        }
        long val1 = sn - s;
        long val2 = s2n - s2;

        val2 = val2 / val1;

        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new ArrayList<>(Arrays.asList((int) y, (int) x));
    }
}
