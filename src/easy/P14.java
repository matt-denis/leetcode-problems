/*
14. Longest Common Prefix
Easy

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lower-case English letters.


*/


package easy;

import java.util.Arrays;

public class P14 {
    
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());
        String shortest = strs[0];
        final int len = strs.length;
        int n = shortest.length();
        if (n < 0) return "";
        for (int m = n - 1; m >= 0; m--) {
            char c = shortest.charAt(m);
            int i;
            for (i = 1; i < len; i++) {
                if (strs[i].charAt(m) != c) break;
            }
            if (i < len) n = m;
        }
        return n == 0 ? "" : shortest.substring(0, n);
    }
}
