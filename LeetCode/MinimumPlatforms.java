package LeetCode;

//URL:https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int maxPlatforms = 1;
        int currentPlatforms = 1;
        int currentArr = 1;
        int currentDep = 0;
        while(currentArr < n && currentDep < n){
            if(arr[currentArr] <= dep[currentDep]){
                currentPlatforms++;
                currentArr++;
            }
            else if(arr[currentArr] > dep[currentDep]){
                currentPlatforms--;
                currentDep++;
            }
            if(currentPlatforms > maxPlatforms){
                maxPlatforms = currentPlatforms;
            }
        }
        return maxPlatforms;
    }
}
