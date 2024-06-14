package LeetCode;

public class SmallestWindowContainingAllCharacters {

    static boolean containsAllCharacters(String subStr, String pattern){
        int[] count = new int[256];
        for(char ch :  pattern.toCharArray()){
            count[ch]++;
        }
        for(char ch : subStr.toCharArray()){
            if(count[ch] > 0){
                count[ch]--;
            }
        }
        for(int i = 0; i < 256; i ++){
            if(count[i] > 0)
                return false;
        }
        return true;
    }
    static String findSmallestSubstring(String str, String pattern) {      //Brute force approach
        int strLen = str.length();
        int patterLen = pattern.length();
        String smallestSubString = "";
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < strLen; i++){
            for(int j = i; j < strLen; j++){
                String subStr = str.substring(i, j + 1);
                if(containsAllCharacters(subStr, pattern)){
                    int currentLength = subStr.length();
                    if(currentLength < minLength){
                        minLength = currentLength;
                        smallestSubString = subStr;
                    }
                }
            }
        }
        return  smallestSubString;
    }
    public static String bestApproach(String str, String pattern){
        int strLen = str.length();
        int patternLen = pattern.length();
        if(strLen < patternLen){
            return "";
        }
        int[] patternMap = new int[256];
        int[] strMap = new int[256];
        for(char ch : pattern.toCharArray()){
            patternMap[ch]++;
        }
        int count = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        for(int i = 0; i < strLen; i++){
            strMap[str.charAt(i)]++;
            if (strMap[str.charAt(i)] <= patternMap[str.charAt(i)])
                count++;
            if(count == patternLen){
                while(strMap[str.charAt(start)] > patternMap[str.charAt(start)] || patternMap[str.charAt(start)] == 0){
                    if(strMap[str.charAt(start)] > patternMap[str.charAt(start)])
                        strMap[str.charAt(start)]--;
                    start++;
                }
                int windowLength = i - start + 1;
                if(windowLength < minLength){
                    minLength = windowLength;
                    startIndex = start;
                }
            }
        }
        if(startIndex == -1)
            return "";
        return str.substring(startIndex, startIndex + minLength);
    }
}
