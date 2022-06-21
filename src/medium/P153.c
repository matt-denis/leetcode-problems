/*
153. Find Minimum in Rotated Sorted Array
Medium

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

 

Constraints:

    n == nums.length
    1 <= n <= 5000
    -5000 <= nums[i] <= 5000
    All the integers of nums are unique.
    nums is sorted and rotated between 1 and n times.


*/

#include <math.h>

int min_in_range(int*, int, int);


int findMin(int* nums, int numsSize){
    int lo = 0, hi = numsSize;
    int mid;
    int first = nums[0];
    while (lo < hi) {
        mid = lo + (hi - lo) / 2;
        if (nums[mid] >= first) lo = mid + 1;
        else hi = mid;
    }
    
    return nums[lo % numsSize];
}

/* recursive implementation */

int findMinRec(int* nums, int numsSize){
    return min_in_range(nums, 0, numsSize - 1);
}

int min_in_range(int* nums, int lo, int hi)
{   
    if (lo == hi) return nums[lo];
    int mid = lo + (hi - lo) / 2;
    return fmin(min_in_range(nums, lo, mid), min_in_range(nums, mid + 1, hi));
}