package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumpadMappingsExclusiveWord {  //SWIGGY ONLINE ASSESSMENT QUESTION!!!!!!!!!!!!!!!!!!!!!
    public static int letterToNumber(char letter) {
        Map<Character, Integer> mappings = new HashMap<>();
        mappings.put('a', 1);
        mappings.put('b', 1);
        mappings.put('c', 2);
        mappings.put('d', 2);
        mappings.put('e', 2);
        mappings.put('f', 3);
        mappings.put('g', 3);
        mappings.put('h', 3);
        mappings.put('i', 4);
        mappings.put('j', 4);
        mappings.put('k', 4);
        mappings.put('l', 5);
        mappings.put('m', 5);
        mappings.put('n', 5);
        mappings.put('o', 6);
        mappings.put('p', 6);
        mappings.put('q', 6);
        mappings.put('r', 7);
        mappings.put('s', 7);
        mappings.put('t', 7);
        mappings.put('u', 8);
        mappings.put('v', 8);
        mappings.put('w', 8);
        mappings.put('x', 9);
        mappings.put('y', 9);
        mappings.put('z', 9);

        return mappings.getOrDefault(letter, 0);
    }

    public static List<String> findCombinations(String word) {
        List<String> exclusiveWords = new ArrayList<>();
        int exclusiveWordCount = 0;
        for (int i = 1; i < word.length(); i++) {
            for (int j = 0; j < word.length() - i; j++) {
                String subWord = word.substring(j, j + i);
                char[] subWordArray = subWord.toCharArray();
                int wordSum = 0;
                for (char letter : subWordArray) {
                    wordSum += letterToNumber(letter);
                }
                if (wordSum % i == 0) {
                    exclusiveWords.add(subWord);
                    exclusiveWordCount++;
                }
            }
        }
        System.out.println("exclusiveWordCount: " + exclusiveWordCount);
        return exclusiveWords;
    }

    public static void main(String[] args) {
        System.out.println(findCombinations("kevin"));
    }
}
