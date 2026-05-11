class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       /*Map<Integer, Integer> count = new HashMap<>();
       for(Integer num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
       }
       List<int[]> arr = new ArrayList<>();
       for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
       }
       arr.sort((a, b) -> b[0] - a[0]);
       int[] ans = new int[k];
       for(int i = 0; i < k; i++) {
         ans[i] = arr.get(i)[1];
       }
       return ans;*/
       Map<Integer, Integer> count = new HashMap<>();
       for(Integer num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
       }
       PriorityQueue<int[]> maxheap = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
       for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
	        maxheap.offer(new int[]{entry.getValue(), entry.getKey()});
       }
       int[] res = new int[k];
       for(int i = 0; i < k; i++) {
      	  res[i] = maxheap.poll()[1];
       }
       return res;
    }
}