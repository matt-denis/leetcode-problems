/*
58. Length of Last Word
Easy

Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

 

Constraints:

    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.


*/


package easy;

public class P58 {
    
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int startIdx = 0, endIdx = n - 1;
        // strip leading and trailing whitespaces
        while (Character.isWhitespace(s.charAt(startIdx))) startIdx++;
        while (Character.isWhitespace(s.charAt(endIdx))) endIdx--;
        int lastSpaceIdx = -1;
        for (int i = startIdx; i <= endIdx; i++) {
            if (Character.isWhitespace(s.charAt(i))) lastSpaceIdx = i;
        }
        return lastSpaceIdx == -1 ? endIdx - startIdx + 1 :
            endIdx  - lastSpaceIdx;
    }
}
