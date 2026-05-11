class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        permute(0, nums, ans);
        return ans;
    }
    private void permute(int i, int[] nums, List<List<Integer>> ans) {
        if(i == nums.length) {
            List<Integer> current = new ArrayList<>();
            for(int n : nums) {
                current.add(n);
            }
            ans.add(current);
            return;
        }
        for(int j = i; j < nums.length; j++) {
            if(j > i && nums[i] == nums[j]) continue;
            swap(i, j, nums);
            permute(i + 1, nums, ans);
        }

        for (int j = nums.length - 1; j > i; j--) {
            swap(i, j, nums);
        }
     }
     private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
     }
}