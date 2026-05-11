class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        for(int R = 0; R < nums.length; R++) {
            sum += nums[R];
            while(sum >= target) {
                minLength = Math.min(minLength, R - L + 1);
                sum -= nums[L];
                L++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}