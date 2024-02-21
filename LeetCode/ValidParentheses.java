package LeetCode;

import java.util.Stack;

public class ValidParentheses {
    //URL:/problems/valid-parentheses/
    public boolean isValid(String s) {  //My dumb approach
        if (s == "")
            return true;
        String bracketList = "(){}[]";
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracketList.indexOf(bracket) % 2 == 0) {
                bracketStack.push(bracket);
            } else if (bracketList.indexOf(bracket) % 2 == 1) {
                int idx = bracketList.indexOf(bracket);
                if (bracketStack.isEmpty() || bracketStack.pop() != bracketList.charAt(idx - 1)) {
                    return false;
                }
            }
        }
        if (bracketStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //URL:/problems/valid-parentheses/
    public boolean approach2(String s) {  //Super cool approach
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{')
                stack.push('}');
            else if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
