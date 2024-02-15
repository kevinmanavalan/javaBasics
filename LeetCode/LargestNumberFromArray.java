package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFromArray {
    public static void main(String[] args) {
        int[] digits = {9, 5, 2, 7, 3};

        String largestNumber = createLargestNumber(digits);
        System.out.println("Largest number: " + largestNumber);
    }

    public static String createLargestNumber(int[] digits) {
        // Convert digits to strings for sorting
        String[] digitStrings = new String[digits.length];
        for (int i = 0; i < digits.length; i++) {
            digitStrings[i] = String.valueOf(digits[i]);
        }
        // Sort the digit strings in descending order
        Arrays.sort(digitStrings, (String a, String b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return (a + b).compareTo(b + a);
        });
        // Concatenate sorted digit strings to form the largest number
        StringBuilder largestNumberBuilder = new StringBuilder();
        for (String digitString : digitStrings) {
            largestNumberBuilder.append(digitString);
        }

        return largestNumberBuilder.toString();
    }
}

