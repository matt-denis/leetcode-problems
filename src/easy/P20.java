/*
20. Valid Parentheses
Easy

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

 

Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.


*/


package easy;

import java.util.Deque;
import java.util.LinkedList;

public class P20 {
    
    private static final String OPEN_PARENS = "([{";
    private static final String CLOSED_PARENS = ")]}";
    public boolean isValid(String s) {
        Deque<Character> parser = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isWhitespace(c)) continue;
            if (OPEN_PARENS.indexOf(c) != -1) {
                parser.push(c);
            } else {
                if (parser.isEmpty()) return false;
                char open = parser.pop();
                if (CLOSED_PARENS.indexOf(c) != OPEN_PARENS.indexOf(open)) return false;
            }
        }
        return parser.isEmpty();
    }
}
