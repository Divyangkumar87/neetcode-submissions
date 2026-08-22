class Solution {
    public int maxArea(int[] heights) {
        int L = 0;
        int R = heights.length - 1;
        int ans = Integer.MIN_VALUE;
        while(L < R) {
            int area = Math.min(heights[L], heights[R]) * (R - L);
            ans = Math.max(area, ans);
            if(heights[L] <= heights[R]) {
                L++;
            } else {
                R--;
            }
        }
        return ans;
    }
}
