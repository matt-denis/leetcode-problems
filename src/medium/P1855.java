/*
1855. Maximum Distance Between a Pair of Values
Medium

You are given two non-increasing 0-indexed integer arrays nums1​​​​​​ and nums2​​​​​​.

A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i​​​​.

Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.

An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.

 

Example 1:

Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
Output: 2
Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
The maximum distance is 2 with pair (2,4).

Example 2:

Input: nums1 = [2,2,2], nums2 = [10,10,1]
Output: 1
Explanation: The valid pairs are (0,0), (0,1), and (1,1).
The maximum distance is 1 with pair (0,1).

Example 3:

Input: nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
Output: 2
Explanation: The valid pairs are (2,2), (2,3), (2,4), (3,3), and (3,4).
The maximum distance is 2 with pair (2,4).

 

Constraints:

    1 <= nums1.length, nums2.length <= 105
    1 <= nums1[i], nums2[j] <= 105
    Both nums1 and nums2 are non-increasing.


*/

package medium;

public class P1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i1 = 0;
        int i2 = 0;
        while (i1 < n1 && i2 < n2) {
            int key = nums1[i1];
            while (i2 < n2 && nums2[i2] >= key) ++i2;
            i2--;
            max = Math.max(max, i2 - i1);
            i2 = ++i1;
        }
        
        
        return max;
        
    }

    public int maxDistanceBSearch(int[] nums1, int[] nums2) {
        int max = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
       for (int i = 0; i < n1; ++i) {
           int right = ceil(nums2, i, n2 - 1, nums1[i]);
           max = Math.max(max, right - i);
       }
        
        return max;
        
        
    }
    
    private int ceil(int[] arr, int lo, int hi, int target) {
        int mid;
        if (lo > hi) return -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (target > arr[mid]) hi = mid - 1;
            else lo  = mid + 1;
        }
        return hi;
    }
}

