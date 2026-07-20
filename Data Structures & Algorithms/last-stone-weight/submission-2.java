class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }
        while(maxHeap.size() > 1) {
            maxHeap.offer(Math.abs(maxHeap.poll() - maxHeap.poll()));
        }
        return maxHeap.peek();
    }
}
