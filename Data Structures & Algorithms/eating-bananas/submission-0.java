class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int ans = Integer.MIN_VALUE;

        int L = 1; 
        int R = Arrays.stream(piles).max().getAsInt();

        while(L <= R) {
            int M = (L + R)/2;
            if(checkEatingSpeed(M, piles, h)) {
                R = M - 1;
                ans = M;
            } else {
                L = M + 1;
            }
        }
        return ans;
    }
    private boolean checkEatingSpeed(int S, int[] piles, int h) {
        long eatingSpeedWithS = 0;
        for(int i = 0; i < piles.length; i++) {
            eatingSpeedWithS += Math.ceil((double)piles[i]/S);
        }
        return eatingSpeedWithS <= h;
    }
}
