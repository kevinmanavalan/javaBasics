package LeetCode;

//URL:https://bit.ly/3rj7Ib1

public class FindNthRoot {
    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while(low <= high){
            int mid = low + ((high - low) / 2);
            long temp = 1;
            for(int i = 0; i < n; i++){
                temp *= mid;
                if(temp > m){
                    high = mid - 1;
                    break;
                }
            }
            if(temp == m)
                return mid;
            else if(temp < m)
                low = mid + 1;
        }
        return -1;
    }
}
