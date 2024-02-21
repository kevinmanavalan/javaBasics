package LeetCode;

public class StringCompression {

    //URL:/problems/string-compression/
    public int compress(char[] chars) {
        int ansIndex = 0, index = 0;
        while (index < chars.length) {
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            chars[ansIndex++] = currentChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[ansIndex++] = c;
                }
            }
        }
        return ansIndex;
    }
}

