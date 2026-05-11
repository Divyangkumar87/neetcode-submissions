class Solution {
    public int shortestPath(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        return bfs(0, 0, grid, visited);
    }
    private int bfs(int r, int c, int[][] grid, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        int[][] directions = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        int length = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 1; i <= size; i++) {
                int[] cell = queue.poll();
                if(cell[0] == grid.length - 1 && cell[1] == grid[0].length - 1) {
                    return length;
                }
                for(int[] dr : directions) {
                    int cr = cell[0] + dr[0];
                    int cc = cell[1] + dr[1];
                    if(cr < 0 || cc < 0 || 
                       cr > grid.length - 1 || cc > grid[0].length - 1 ||
                       grid[cr][cc] == 1 || visited[cr][cc]) {
                        continue;
                    }
                    visited[cr][cc] = true;
                    queue.add(new int[]{cr, cc});
                }
            }
            length++;
        }
        return -1;
    }
}
