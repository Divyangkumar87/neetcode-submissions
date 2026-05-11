class Solution {
    public int numIslands(char[][] grid) {
        int[][] directions = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
        int islands = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    dfs(r, c, directions, grid);
                    islands++;
                }  
            }
        }
        return islands;
    }
    private void dfs(int r, int c, int[][] directions, char[][] grid) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for(int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], directions, grid);
        }
    }
}
