package LeetCode;

/*A couple of houses needs to be built in a lane using either wood or brick or steel.
no two adjacent houses in a lane can be of same material.
Find out the cheapest way to build all houses
suppose
consider below example
consider this matrix for info
                      material1   material2   material3
house1 cost |        1       |       2        |       2
house2 cost |        2       |       2        |       1
house3 cost |        1       |       3        |       3

in this case the cheapest way would be to use material1 for house1, material3 for house2, material1 for house3
hence total cost 1 + 1 + 1 = 3*/

import java.util.Arrays;

public class HousesInALane_HackerRank {

    public static int minCost(int[][] costs){
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        System.arraycopy(costs[0], 0, dp[0], 0, 3);
//        System.out.println(Arrays.deepToString(dp));
        for(int i = 1; i < n; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        System.out.println(Arrays.deepToString(dp));
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }


    public static void main(String[] args) {
        int[][] costs = {
                {1, 2, 2},
                {2, 2, 1},
                {1, 3, 3}
        };
        System.out.println(minCost(costs));
    }

    //Recursive approach
    public static int minCost2(int[][] costs){
        int n = costs.length;
        int[][] memo = new int [n][3];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return Math.min(minCostHelper(costs, 0, 0, memo), (Math.min(minCostHelper(costs, 0, 1, memo), minCostHelper(costs, 0, 2, memo))));
    }
    public static int minCostHelper(int[][] costs, int house, int material, int[][] memo){
        if(house == costs.length)
            return 0;
        if(memo[house][material] != -1){
            return memo[house][material];
        }
        int totalCost = costs[house][material];
        if (material == 0)
            totalCost += Math.min(minCostHelper(costs, house + 1, 1, memo), minCostHelper(costs, house + 1, 2, memo));
        if (material == 1)
            totalCost += Math.min(minCostHelper(costs, house + 1, 0, memo), minCostHelper(costs, house + 1, 2, memo));
        if (material == 2)
            totalCost += Math.min(minCostHelper(costs, house + 1, 0, memo), minCostHelper(costs, house + 1, 1, memo));
        memo[house][material] = totalCost;
        return totalCost;
    }
}
