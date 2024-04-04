package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

//URL:/problems/merge-intervals/description/

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<List<Integer>> results = new ArrayList<>();


        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });


        for (int i = 0; i < n; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                results.add(List.of(left, right));
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        if (intervals[n - 1][0] > right) {
            results.add(Arrays.stream(intervals[n - 1]).mapToObj(Integer::valueOf).collect(Collectors.toList()));


//            👇ANOTHER APPROACH TO CONVERT ARRAY TO LIST.👇
//            List<Integer> intervalList = new ArrayList<>();
//            for (int num : intervals[n - 1]) {
//                intervalList.add(num);
//            }
//            results.add(intervalList);

        }
        int[][] resultArray = new int[results.size()][2];
        for (int i = 0; i < results.size(); i++) {
            resultArray[i] = results.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 4}, {0, 4}};
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        for (int[] a : arr) {
            Arrays.stream(a).forEach(System.out::println);
        }

    }
}
