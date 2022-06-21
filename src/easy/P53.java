/*
53. Maximum Subarray
Easy

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

Input: nums = [1]
Output: 1

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

 

Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/


package easy;

public class P53 {
    
    /* dynamic programming bottom-up approach ; complexity ~ 2n ; 2 traversals */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        max[0] = nums[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1] + nums[i], nums[i]);
        }
        int maxVal = Integer.MIN_VALUE;
        for (int e : max) { maxVal = Math.max(maxVal, e); }
        return maxVal;
    }
    
    
    public int maxSubArraySlow(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
        
        int max = sums[0]; // start by considering single first element
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, sums[i] - sums[j]);
            }
            /* considers the sum of the whole subarray
              from start included to finish */
            max = Math.max(max, sums[i]); 
        }
        
        return max;
    }
}
