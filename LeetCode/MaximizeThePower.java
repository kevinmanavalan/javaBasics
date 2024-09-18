package LeetCode;

import java.util.*;

// sum rubbish hackerrank question


class MaximizeThePower {

    /*
     * Complete the 'getMaximumPower' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY power
     */

    public static int getMaximumPower(List<Integer> arr, List<Integer> power) {
        int noOfOperations = power.size() / 2;
        int sum = 0;
        int mod = 1000000007;

        for (int i = 0; i < noOfOperations; i++) {
            if (power.isEmpty())
                return sum % mod;

            List<Integer> values = minMax(power);
            int l = values.get(0);
            int r = values.get(1);

            for (int j = power.get(l); j <= power.get(r); j++) {
                sum += arr.get(j);
            }

            // Remove elements at indices l and r
            power.remove(Math.max(l, r));
            power.remove(Math.min(l, r));
        }

        return sum % mod;
    }

    public static List<Integer> minMax(List<Integer> powers) {
        int maxK = 0;
        int minK = 0;

        for (int i = 1; i < powers.size(); i++) {
            if (powers.get(i) > powers.get(maxK))
                maxK = i;
            if (powers.get(i) < powers.get(minK))
                minK = i;
        }

        return List.of(minK, maxK);
    }
}
