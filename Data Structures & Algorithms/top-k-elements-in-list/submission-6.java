class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        Map<Integer, int[]> map = new HashMap<>();
        int[] ans = new int[k];

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int[] arr = map.get(nums[i]);
                arr[1]++;
            } else {
                map.put(nums[i], new int[]{nums[i], 1});
            }
        }

        System.out.println(map);

        for(Integer key : map.keySet()) {
            heap.offer(map.get(key));
        }

        for(int i = 0; i < k; i++) {
            ans[i] = heap.poll()[0];
        }

        return ans;
    }
}
