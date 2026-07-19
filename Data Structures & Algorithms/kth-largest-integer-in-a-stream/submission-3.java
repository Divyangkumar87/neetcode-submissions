class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k = 0;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>();
        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        this.k = k;
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
