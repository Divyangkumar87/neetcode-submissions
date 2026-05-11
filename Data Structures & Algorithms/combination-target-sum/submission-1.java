class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSum(0, nums, target, ans, current);
        return ans;
    }
    private void combinationSum(int i, int[] nums, int target, List<List<Integer>> ans, List<Integer> current) {
        //base condition
        if(target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        if(target < 0) {
            return;
        }

        for(int j = i; j < nums.length; j++) {
            //include
            current.add(nums[j]);
            combinationSum(j, nums, target - nums[j], ans, current);
            //exclude
            current.remove(current.size() - 1);
        }
    }
}
