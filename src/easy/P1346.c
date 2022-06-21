/*
1346. Check If N and Its Double Exist
Easy

Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]

 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

Example 2:

Input: arr = [7,1,14,11]
Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.

Example 3:

Input: arr = [3,1,7,11]
Output: false
Explanation: In this case does not exist N and M, such that N = 2 * M.

 

Constraints:

    2 <= arr.length <= 500
    -10^3 <= arr[i] <= 10^3


*/

#include <stdlib.h>
#include <stdbool.h>

int cmp(const void *a, const void *b)
{
    return *(int*)a - *(int*)b;
}

int bin_search(int *arr, int lo, int hi, int target) 
{
    int mid;
    while (lo <= hi) {
        mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) return mid;
        if (target < arr[mid]) hi = mid - 1;
        else lo = mid + 1;
    }
    return -1;
}

bool checkIfExist(int* arr, int arrSize){
    qsort(arr, arrSize, sizeof(int), cmp);
    for (int i = 0; i < arrSize; ++i) {
        if (arr[i] < 0) {
            if (bin_search(arr, 0, i - 1, 2 * arr[i]) != -1) return true; 
        }
        if (arr[i] >= 0) {
            if (bin_search(arr, i + 1, arrSize - 1, 2 * arr[i]) != -1) return true;
        }
        
    }
    return false;
}