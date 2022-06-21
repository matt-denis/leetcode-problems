/*
74. Search a 2D Matrix
Medium

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

 

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

 

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104


*/

#include <vector>
using std::vector;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        int lo = 0;
        int hi = m * n - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int col = mid % n;
            int row = mid / n;
            if (matrix[row][col] == target) return true;
            if (target < matrix[row][col]) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return false;
    }
};