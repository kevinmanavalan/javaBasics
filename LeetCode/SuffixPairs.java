package LeetCode;


//VISA OA not right answer!!!!!!!

import java.util.*;

public class SuffixPairs {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    static void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            node.count++;
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.count++;
    }

    static int countPairs(TrieNode root, String word) {
        TrieNode node = root;
        int count = 0;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                return count;
            }
            node = node.children.get(ch);
            count += node.count;
        }
        return count;
    }

    public static int solution(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }
        int pairs = 0;
        for (String word : words) {
            pairs += countPairs(root, word) - 1;
        }
        return pairs / 2;
    }

    public static void main(String[] args) {
        String[] words = {"cba", "a", "a", "b", "ba", "ca"};
        System.out.println(solution(words));  // Output: 3
    }
}
