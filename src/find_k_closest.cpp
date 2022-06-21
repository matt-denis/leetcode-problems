#include <vector>

using std::vector;

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> result;
        const int n = arr.size();
        int lo = -1, hi = n;
        int mid;
        int idx;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (mid < 0) break;
            if (arr[mid] == x) {
                lo = mid;
                break;
            }
            else if (x < arr[mid]) hi = mid - 1;
            else lo = mid + 1; 
        }
        idx = lo;
        int count = 0;
        lo = idx - 1, hi = idx >= 0 ? idx : 0;
        while (count < k && (lo >= 0 || hi < n)) {
            if (hi < n) {
                result.push_back(arr[hi++]);
                ++count;
            }
            if (lo >= 0 && count < k) {
                result.insert(result.begin(), arr[lo--]);
                ++count;
            }
        }
        
        return result;
    }
};