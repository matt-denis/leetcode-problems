/*
1351. Count Negative Numbers in a Sorted Matrix
Easy

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100

 
Follow up: Could you find an O(n + m) solution?
*/

#include <vector>

using std::vector;


class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int count = 0;
        int m = grid.size();
        for (int row = 0; row < m; ++row) {
            int n = grid[row].size();
            int lo = 0, hi = n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (grid[row][mid] >= 0) lo = mid + 1;
                else hi = mid - 1;
            }
            count += n - lo;
        }
        
        return count;
    }
};

class Solution2 {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int count = 0;
        int m = grid.size();
        int hiLim = grid[0].size();
        for (int row = 0; row < m && hiLim >= 0; ++row) {
            int lo = 0, hi = hiLim - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (grid[row][mid] >= 0) lo = mid + 1;
                else hi = mid - 1;
            }
            count += (hiLim - lo) * (m - row); 
            hiLim = lo;
        }
        
        return count;
    }
};