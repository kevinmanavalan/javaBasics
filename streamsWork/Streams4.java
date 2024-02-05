package streamsWork;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.*;

public class Streams4 {
    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4, 4};
        System.out.println(sumOfUnique(arr));

    }

    public static int sumOfUnique(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .mapToInt((key) -> key.getKey())
                .sum();
    }
}
