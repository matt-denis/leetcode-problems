/*
28. Implement strStr()
Easy

Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

 

Constraints:

    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.


*/


package easy;

public class P28 {
    
    private static int d = 256; // large number minimizes spurious hits
    private static int q = 101; // large prime number
    
    /* implement using robin-karp algorithm */
    public int strStr(String haystack, String needle) {
        final int m = needle.length();
        final int n = haystack.length();
        if (m == 0) return 0;
        if (m > n) return -1;
        // pre-compute highest polynomial variable d^(m - 1)
        int h = 1; // multiplicative identity
        for (int i = 1; i <= m - 1; i++) {
            h = (h * d) % q;
        }
        // compute hashes
        int needleHash = 0, haystackHash = 0;
        for (int i = 0; i < m; i++) {
            needleHash = (needleHash * d + needle.charAt(i)) % q;
            haystackHash = (haystackHash * d + haystack.charAt(i)) % q;
        }
        // compare pattern hash to text's rolling hash
        for (int i = 0; i < n - m + 1; i++) {
            if (needleHash == haystackHash) {
                int j;
                for (j = i; j < i + m; j++) {
                    if (needle.charAt(j - i) != haystack.charAt(j)) break; 
                }
                if (j - i == m) return i;
            }
            if (i < n - m) {
                haystackHash = (d * (haystackHash - h * haystack.charAt(i)) + haystack.charAt(i + m)) % q;
                if (haystackHash < 0) haystackHash += q;
            }
        }
        return -1;
    }
}
