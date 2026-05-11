class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }
    private int dfs(int r, int c, int rows, int columns) {
        if(r >= rows || c >= columns) return 0;
        if(r == rows - 1 && c == columns - 1) return 1;
        return dfs(r + 1, c, rows, columns) + dfs(r, c + 1, rows, columns);
    }
}
