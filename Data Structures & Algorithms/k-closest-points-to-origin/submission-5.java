class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> max = 
        new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));
        
        for(int[] point : points) {
            max.offer(point);
            if(max.size() > k) {
                max.poll();
            }
        }

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            ans[i] = max.poll();
        }
        return ans;
    }
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
