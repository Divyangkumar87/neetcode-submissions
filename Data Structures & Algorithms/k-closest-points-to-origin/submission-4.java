class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> max = 
        new PriorityQueue<>((a, b) -> Integer.compare(distance(b[0], b[1]),
                                                        distance(a[0], a[1])));
        
        for(int i = 0; i < points.length; i++) {
            max.offer(points[i]);
            if(max.size() > k) {
                max.poll();
            }
        }

        System.out.println(max);

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            ans[i] = max.poll();
        }
        return ans;
    }
    private int distance(int x, int y) {
        return x*x + y*y;
    }
}
