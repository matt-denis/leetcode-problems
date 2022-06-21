/*
67. Add Binary
Easy

Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 

Constraints:

    1 <= a.length, b.length <= 104
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.


*/


package easy;

public class P67 {
    
    public String addBinary(String a, String b) {
        // in case of equality a becomes the shortest and b the longer strings by default
        String minStr = a.length() <= b.length() ? a : b;
        String maxStr = b.length() >= a.length() ? b : a;
        int minlen = minStr.length();
        int maxlen = maxStr.length();
        for (int i = 1; i <= maxlen - minlen; i++) {
            minStr = '0' + minStr; // pad the shortest string
        }
        String res = "";
        boolean rem = false;
        final int offset = 48;
        for (int i = maxlen - 1; i >= 0; i--) {
            int sum = ((minStr.charAt(i) - offset) + (maxStr.charAt(i) - offset));
            if (rem) {
                sum++;
                rem = false; // remanider used
            }
            if (sum == 2) {
                res = '0' + res;
                sum = 0;
                rem = true;
            }
            else if (sum == 3) {
                res = '1' + res;
                rem = true; 
            }
            else {
                res = ((char)(sum + 48)) + res;
            }
            
        }
        
        if (rem) res = '1' + res;
        
        return res;
        
    }
}
