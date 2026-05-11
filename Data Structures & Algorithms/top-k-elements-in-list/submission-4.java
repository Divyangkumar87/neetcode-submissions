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
       /*Map<Integer, Integer> count = new HashMap<>();
       for(Integer num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
       }
       PriorityQueue<int[]> maxheap = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
       for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
	        maxheap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(maxheap.size() > k) {
                maxheap.poll();
            }
       }
       int[] res = new int[k];
       for(int i = 0; i < k; i++) {
      	  res[i] = maxheap.poll()[1];
       }
       return res;*/
       Map<Integer, Integer> count = new HashMap<>();
       for(Integer num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
       }
       List<Integer>[] freq = new List[nums.length + 1];
       for(int i = 0; i < freq.length; i++) {
            freq[i]=new ArrayList<>();
       }
       for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
       }
       int[] res = new int[k];
       int index = 0;
       for(int i = freq.length - 1; i > 0; i--) {
            for(Integer num : freq[i]) {
                res[index++] = num;
                if(index == k) {
                    return res;
                }
            }
       }
       return res;
    }
}