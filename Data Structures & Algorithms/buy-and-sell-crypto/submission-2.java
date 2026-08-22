class Solution {
    public int maxProfit(int[] prices) {
        int L = 0;
        int R = L + 1;
        int profit = 0;
        while(R < prices.length) {
            if(prices[R] - prices[L] > 0) {
                profit = Math.max(profit, prices[R] - prices[L]);
            } else {
                L = R;
            }
            R++;
        }
        return profit;
    }
}
