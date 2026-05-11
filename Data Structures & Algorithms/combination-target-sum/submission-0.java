class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSum(nums, target, 0, ans, current);
        return ans;
    }
    private void combinationSum(int[] nums, int target, int i, List<List<Integer>> ans, List<Integer> current) {
        //base condition
        if(target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        if(target < 0 || i >= nums.length) {
            return;
        }

        //include
        current.add(nums[i]);
        combinationSum(nums, target - nums[i], i, ans, current);

        //exclude
        current.remove(current.size() - 1);
        combinationSum(nums, target, i + 1, ans, current);
    }
}
