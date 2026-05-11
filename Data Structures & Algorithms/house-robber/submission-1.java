class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums, 0, dp);
    }

    private int solve(int[] nums, int i, int[] dp) {
        if(i >= nums.length) return 0;
        if(nums.length == 1) return nums[i];
        if(dp[i] != -1) return dp[i];
        int include = solve(nums, i + 2, dp) + nums[i];
        int exclude = solve(nums, i + 1, dp) + 0;
        dp[i] = Math.max(include, exclude);
        return dp[i];
    }
}
