class Solution {
    public int maxProfit(int[] prices) {
        
        int l = 0;
        int r = 1;
        int ans = 0;

        while(r < prices.length) {
            if(prices[l] < prices[r]) {
                ans = Math.max(ans, (prices[r] - prices[l]));
                r++;
            } else {
                r++;
                l = r - 1;
            }
        }

        return ans;
    }
}
