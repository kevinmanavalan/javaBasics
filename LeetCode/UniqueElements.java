package LeetCode;

import java.util.HashSet;

public class UniqueElements {
    public int uniqueCharacters(String str) {
        HashSet<Character> set = new HashSet<>();
        char[] list = str.toCharArray();
        for (char element : list) {
            set.add(element);
        }
        return set.size();
    }
}
