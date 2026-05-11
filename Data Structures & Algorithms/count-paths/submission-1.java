class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return dfs(0, 0, m, n, dp);
    }
    private int dfs(int r, int c, int rows, int columns, int[][] dp) {
        if(r >= rows || c >= columns) return 0;
        if(r == rows - 1 && c == columns - 1) return 1;
        if(dp[r][c] != 0) return dp[r][c];
        dp[r][c] = dfs(r + 1, c, rows, columns, dp) + dfs(r, c + 1, rows, columns, dp);
        return dp[r][c];
    }
}
