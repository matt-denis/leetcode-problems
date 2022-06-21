/*
35. Search Insert Position
Easy

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

 

Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104


*/


int searchInsert(int* nums, int numsSize, int target){
    int i;
    for (i = 0; i < numsSize; i++) {
        if (*(nums + i) >= target) return i;
    }
    return i;
}

/* same as looking for the floor of target */
int searchInsertBinary(int* nums, int numsSize, int target){
    int lo = 0, hi = numsSize;
    
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) return mid;
        if (target < nums[mid]) hi = mid;
        else lo = mid + 1;
    }
    
    return lo;
}
