class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        Arrays.fill(cache, -1);
        return dfs(n, 0);
    }
    private int dfs(int n, int i) {
        if(i == n) return 1;
        if(i > n) return 0;
        if(cache[i] != -1) return cache[i];
        cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
        return cache[i]; 
    }
}
