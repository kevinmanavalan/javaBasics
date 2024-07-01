package LeetCode;

//URL:https://bit.ly/3PvwuPk

public class MedianInRow_wiseSortedMatrix {
    int median(int[][] matrix, int R, int C) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < R; i++){
            low = Math.min(matrix[i][0], low);
            high = Math.max(matrix[i][C - 1], high);
        }
        int required = (R * C) / 2;
        while(low <= high){
            int mid = (low + high) / 2;
            int allSmallThanMid = valuesSmaller(matrix, R, C, mid);
            if(allSmallThanMid <= required)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    static int valuesSmaller(int[][] matrix, int R, int C, int target){
        int count = 0;
        for(int i = 0; i < R; i++){
            count += upperBound(matrix[i], target, C);
        }
        return count;
    }

    static int upperBound(int[] matrix, int target, int C){
        int low = 0;
        int high = C - 1;
        int count = C;
        while(low <= high){
            int mid = (low + high) / 2;
            if(matrix[mid]  > target){
                count = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return count;
    }
}
