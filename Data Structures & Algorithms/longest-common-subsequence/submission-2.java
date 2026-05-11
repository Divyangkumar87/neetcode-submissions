class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i] , -1);
        }
        return solve(0, 0, text1, text2, dp);
    }
    private int solve(int i, int j, String text1, String text2, int[][] dp) {
        if(i >= text1.length() || j >= text2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) return 1 + solve(i + 1, j + 1, text1, text2, dp);
        dp[i][j] = Math.max(solve(i + 1, j, text1, text2, dp), solve(i, j + 1, text1, text2, dp));
        return dp[i][j];
    }
}
