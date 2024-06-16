package LeetCode;


//URL:https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#

import java.util.Arrays;

class Job{
    int id;
    int profit;
    int deadline;
    public Job(int id, int profit, int deadline){
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}


public class JobSequencingProblem {

    int[] JobScheduling(Job arr[], int n){
        Arrays.sort(arr, (j1, j2)-> Integer.compare(j2.profit, j1.profit));
        int jobCount = 0;
        int profit = 0;
        int longestDeadline = 0;
        for(Job job : arr){
            if(job.deadline > longestDeadline){
                longestDeadline = job.deadline;
            }
        }
        int[] schedules = new int[longestDeadline + 1];
        for(int i = 0; i <= longestDeadline; i++){
            schedules[i] = -1;
        }
        for(int i = 0; i < n; i++){
            for(int j = arr[i].deadline; j > 0; j--){
                if(schedules[j] == -1){
                    schedules[j] = arr[i].id;
                    jobCount++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{jobCount, profit};
    }
}
