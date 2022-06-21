/*
5. Longest Palindromic Substring
Medium

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

 

Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.


*/

#include <string>
#include <cmath>
#include <utility>

using std::pair;
using std::string;
using std::make_pair;

class Solution {
public:
    string longestPalindrome(string s) {
        int max_len = 0;
        int l, r;
        const int n = s.length();
        for (int i = 0; i < n; i++) {
            int left = i, right = i;
            int len = len_palin(s, left, right, n);
            if (len > max_len) {
                max_len = len;
                l = left;
                r = right;
            }
            left = i - 1;
            right = i;
            len = len_palin(s, left, right, n);
            if (len > max_len) {
                max_len = len;
                l = left;
                r = right;
            }
            
        }
        
        return s.substr(l, r - l + 1);
    }
    
private:
    int len_palin(const string& s, int& left, int& right, const int n) {
        while (left >= 0 && right < n && s[left] == s[right]) {
            left--;
            right++;
        }
        left++;
        right--;
        return right - left + 1;
    }
};


/* dynamic programming solution */
class Solution2 {
public:
    string longestPalindrome(string s) {
        auto p = find_longest_tab(s);
        return s.substr(p.first, p.second - p.first + 1);
    }
    
    
    
    pair<int, int> find_longest_tab(string& s)
    {
        const int n = s.length();
        int tab[n][n];
        bool is_palin[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                is_palin[i][j] = false;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                is_palin[i][j] = true;
            }
        }
        
        // left -> rows, right -> columns
        int longest{0};
        int l = 0, r = 0;
        for (int right = 1; right < n; ++right) {
            for (int left = right - 1; left >= 0; --left) {
                if (s[left] == s[right] && is_palin[left + 1][right - 1]) {
                    is_palin[left][right] = true;
                    int len = right - left + 1;
                    if (len > longest) {
                        longest = len;
                        l = left;
                        r = right;
                    }
                }
                
            }
        }
        
        return make_pair(l, r);
        
    }
    
    
    
};