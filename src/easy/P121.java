package easy;

public class P121 {

    // time = O(n^2)
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for (int buy = 0; buy < n - 1; buy++) {
            for (int sell = buy + 1; sell < n; sell++) {
                if (sell - buy > maxProfit) maxProfit = sell - buy;
            }
        }

        return maxProfit;
    }

    // time = O(n)
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int minBuy = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            if (prices[i] < minBuy) minBuy = prices[i];
            else maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }

        return maxProfit;
    }
}