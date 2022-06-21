/*
33. Search in Rotated Sorted Array
Medium

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1

 

Constraints:

    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104


*/


package medium;

public class P33 {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
        
    }
    
    // time = O(n): T(n) = 2T(n/2) + O(1)
    // space = time
    private int search(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) /2;
        if (target == nums[mid]) return mid;
        return Math.max(search(nums, lo, mid - 1, target),
                                                    search(nums, mid + 1, hi, target));
        
    }

    // time = lg(n)
    public int search2(int[] nums, int target) {
        return search2(nums, 0, nums.length - 1, target);
    }

    private int search2(int[] nums, int lo, int hi, int target) {

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            }
            else {
                if (target <= nums[hi] && target > nums[mid]) lo = mid + 1;
                else hi = mid - 1;
            }
        }

        return -1;
        
    }

    
}