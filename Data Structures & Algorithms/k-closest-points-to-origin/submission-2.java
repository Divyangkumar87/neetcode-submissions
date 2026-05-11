class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> minHeap = new PriorityQueue<>(new PointComparator());
        int[][] ans = new int[k][2];
        for(int[] point : points) {
            int euclideanDistance = getEuclideanDistance(point[0], point[1]);
            Point p = new Point(point[0], point[1], euclideanDistance);
            minHeap.offer(p);
        }
        for(int i = 0; i < k; i++) {
            Point p = minHeap.poll();
            ans[i] = new int[] {p.x, p.y};
        }
        return ans;
    }
    private int getEuclideanDistance(int x, int y) {
        return x*x + y*y;
    }
}
class Point {
    Integer x;
    Integer y;
    int euclideanDistance;
    public Point(Integer x, Integer y, int euclideanDistance) {
        this.x = x;
        this.y = y;
        this.euclideanDistance = euclideanDistance;
    }
}
class PointComparator implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        return p1.euclideanDistance - p2.euclideanDistance;
    }
}