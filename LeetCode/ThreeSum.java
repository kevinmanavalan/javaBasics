package LeetCode;


//URL:https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
import java.util.*;
import java.util.List;
public class ThreeSum {
    public static List< List < Integer > > triplet(int n, int []arr) {
        List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(arr);
            for(int i = 0; i < n; i++){
                if(i != 0 && arr[i] == arr[i-1])
                    continue;
                int j = i + 1;
                int k = n - 1;
                while(j < k){
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum > 0){
                        k--;
                    }
                    else if(sum < 0){
                        j++;
                    }
                    else{
                        ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                        j++;
                        k--;
                        while(j < k && arr[j] == arr[j-1])
                            j++;
                        while(k > j && arr[k] == arr[k+1])
                            k--;
                    }
                }
            }
            return ans;
        }
    }
