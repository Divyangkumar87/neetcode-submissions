class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        //[-1,0,1,2,-1,-4]
        //[-4,-1,-1,0,1,2]
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    if(!set.contains(nums[i] + "-" + nums[j] + "-" + nums[k])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]); list.add(nums[j]); list.add(nums[k]);
                        ans.add(list);
                        set.add(nums[i] + "-" + nums[j] + "-" + nums[k]);
                    }
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}
