class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i = 0;
        Map<String, List<Integer>> ans = new HashMap<>();

        Arrays.sort(nums);
        while(i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    if(!ans.containsKey( "" + nums[i] + nums[j] + nums[k])) {
                        ans.put("" + nums[i] + nums[j] + nums[k], new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                    j++;
                    k--;
                }
            }
            i++;
        }
        return new ArrayList<>(ans.values());
    }
}
