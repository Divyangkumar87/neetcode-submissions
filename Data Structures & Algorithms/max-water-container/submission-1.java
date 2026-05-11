class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int L = 0;
        int R = heights.length - 1;
        while(L < R) {
            int area = (R-L) * Math.min(heights[R], heights[L]);
            maxArea = Math.max(area, maxArea);
            if(heights[L] <= heights[R]) {
                L++;
            } else {
                R--;
            }
        }
        return maxArea;
    }
}
