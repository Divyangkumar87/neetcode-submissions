class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(0, 0, obstacleGrid, dp);
    }

    private int dfs(int r, int c, int[][] obstacleGrid, int[][] dp) {
        if(r >= obstacleGrid.length || c >= obstacleGrid[0].length) return 0;
        if(obstacleGrid[r][c] == 1) return 0;
        if(r == obstacleGrid.length - 1 && c == obstacleGrid[0].length - 1) return 1;
        if(dp[r][c] != 0) return dp[r][c];
        dp[r][c] = dfs(r + 1, c, obstacleGrid, dp) +  dfs(r, c + 1, obstacleGrid, dp);
        return dp[r][c];
    }
}