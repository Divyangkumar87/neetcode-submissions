class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsets(nums, 0, current, ans);
        return ans;
    }
    private void subsets(int[] nums, int i, List<Integer> current, List<List<Integer>> ans) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        //include
        current.add(nums[i]);
        subsets(nums, i + 1, current, ans);
        

        //exclude
        current.remove(current.size() - 1);
        subsets(nums, i + 1, current, ans);
    }
}
