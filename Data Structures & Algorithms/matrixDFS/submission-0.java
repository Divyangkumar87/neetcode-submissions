class Solution {
    public int countPaths(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(0, 0, grid, visited);
    }
    private int dfs(int r, int c, int[][] grid, boolean[][] visited) {
        if(r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1
            || grid[r][c] == 1 || visited[r][c]) {
                return 0;
        }
        if(r == grid.length - 1 && c == grid[0].length - 1) {
            return 1;
        }
        visited[r][c] = true;
        int count = 0;
        count += dfs(r + 1, c, grid, visited);
        count += dfs(r - 1, c, grid, visited);
        count += dfs(r, c + 1, grid, visited);
        count += dfs(r, c - 1, grid, visited);
        visited[r][c] = false;
        return count;
    }
}
