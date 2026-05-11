class Solution {
    public int climbStairs(int n) {
        return dfs(n, 0);
    }
    private int dfs(int n, int current) {
        if(current == n) return 1;
        if(current > n) return 0;
        int noOfWays = dfs(n, current + 1) + dfs(n, current + 2);
        return noOfWays; 
    }
}
