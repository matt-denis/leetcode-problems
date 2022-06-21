/*
48. Rotate Image
Medium

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

 

Constraints:

    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000


*/


package medium;

public class P48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int row = lo;
            for (int col = lo; col < hi; col++) {
                int out = matrix[row][col];
                int walkRow = row, walkCol = col;
                do {
                    int nextCol = (n - 1) - walkRow;
                    int nextRow = walkCol;
                    int nextOut = matrix[nextRow][nextCol];
                    matrix[nextRow][nextCol] = out;
                    out = nextOut;
                    walkRow = nextRow;
                    walkCol = nextCol;
                } while(walkRow != row || walkCol != col);
            }
            lo++;
            hi--;
        }
    }
}