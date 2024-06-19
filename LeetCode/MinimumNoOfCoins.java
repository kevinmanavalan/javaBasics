package LeetCode;

//URL:https://takeuforward.org/data-structure/find-minimum-number-of-coins/

public class MinimumNoOfCoins {
    public int minCoins(int coins[], int M, int V)       //The practical version where no two changes add up to another change
    {                                                    //greater than them. OR the "greedy situation"
        int sum = V;
        int i = M - 1;
        int count = 0;
        while(sum > 0 && i >= 0){
            if(sum >= coins[i]){
                sum -= coins[i];
                count++;
            }
            else{
                i--;
            }
        }
        return sum > 0 ? -1 : count;
    }
    
}
