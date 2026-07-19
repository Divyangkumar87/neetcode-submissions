class KthLargest {

    private PriorityQueue<Integer> maxHeap;
    private int k = 0;

    public KthLargest(int k, int[] nums) {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num : nums) {
            maxHeap.offer(num);
        }
        this.k = k;
    }
    
    public int add(int val) {
        maxHeap.offer(val);
        List<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= k; i++) {
            temp.add(maxHeap.poll());
        }
        int kthLargest = temp.get(temp.size() - 1);
        for(Integer num : temp) {
            maxHeap.offer(num);
        }
        return kthLargest;
    }
}
