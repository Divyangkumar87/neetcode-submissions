class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> quad = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        kSum(nums, 0, 4, (long)target);
        return res;
    }
    private void kSum(int[] nums, int start, int k, long target) {
        if(k == 2) {
            int l = start, r = nums.length - 1;
            while(l < r) {
                long sum = (long)nums[l] + nums[r];
                if(sum < target) {
                    l++;
                } else if(sum > target) {
                    r--;
                } else {
                    List<Integer> current = new ArrayList<>(quad);
                    current.add(nums[l]);
                    current.add(nums[r]);
                    res.add(current);
                    l++;
                    while(l < r && nums[l] == nums[l - 1]) l++;
                }
            }
            return;
        }

        for(int i = start; i <= nums.length - k; i++) {
            if(i > start && nums[i] == nums[i - 1]) continue;
            quad.add(nums[i]);
            kSum(nums, i + 1, k - 1, target - nums[i]);
            quad.remove(quad.size() - 1);
        }
    }
}