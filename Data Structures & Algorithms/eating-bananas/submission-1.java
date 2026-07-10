class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = max(piles);
        int ans = Integer.MAX_VALUE;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(eatingRate(h, m, piles)) {
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public int max(int[] piles) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public boolean eatingRate(int h, int m, int[] piles) {
        double hours = 0.0;
        for(int i = 0; i < piles.length; i++) {
            hours += Math.ceil((double)piles[i]/m);
        }
        return hours <= h;
    }
}
