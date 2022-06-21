package medium;

public class P122 {
    
    // time complexity = O(n)
    // space complexiy = O(n)
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int total = 0;
        int valley = Integer.MAX_VALUE;
        int peak =valley;

        for (int i = 0; i < n; i++) {
            if (prices[i] < peak) {
                total += peak - valley;
                valley = peak = prices[i];
            } else {
                peak = prices[i];
            }
        }
        // when loop finishes it might not add a last positive difference
        // when the end is a peak (higher than the previous valley) the difference is positive
        // otherwise the peak and valley are updated to the terminating valley in the last iteration
        // so the diffence is zero in this case
        total += peak - valley;

        return total;
    }

    // time = O(n)
    // space = O(1)
    // strategy: add positive differences
    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) total += prices[i] - prices[i - 1];
        }
        return total;
    }
}
