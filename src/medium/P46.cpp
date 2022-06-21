/*
46. Permutations
Medium

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

 

Constraints:

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.


*/

#include <vector>

using std::vector;

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> perm;
        int len = nums.size();
        fill_permutations(perm, nums, 0, len);
        return perm;
    }
    
    void fill_permutations(vector<vector<int> >& perm, vector<int>& v, int index, const int len) {
        if (index == len) {
            vector<int> p(v);
            perm.push_back(p);
            return;
        }
        fill_permutations(perm, v, index + 1, len);
        for (int i = index + 1; i < len; ++i){
            swap(v, index, i);
            fill_permutations(perm, v, index + 1, len);
            swap(v, index, i);
        }
    }
    
    void swap(vector<int> &v, int i, int j) {
        int tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }
};