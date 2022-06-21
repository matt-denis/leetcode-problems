/*
9. Palindrome Number
Easy

Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

    For example, 121 is a palindrome while 123 is not.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 

Constraints:

    -231 <= x <= 231 - 1

 
Follow up: Could you solve it without converting the integer to a string?
*/


package easy;

public class P9 {
    
    public boolean isPalindrome(int x) {
        /* The solution regards negative numbers as non-palindromic as the minus sign is read. */
        if (x < 0) return false;
        /* This will be the reverse of x e.g.
        x = 12 => y = 21 */
        int y = 0; 
        int tmp = x;
        while (tmp != 0) {
            y = 10 * y + tmp % 10;
            tmp /= 10;
        }
        
        while (x != 0) { 
            if (x % 10 != y % 10) return false;
            x /= 10;
            y /= 10;
        }
        assert y == 0 : "y does did have the same number of digits as x. Check first while loop.";
        
        return true;
    }
}
