class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, nums, ans, list);
        return ans;
    }

    public void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> list) {
        if(i > nums.length - 1) {
            ans.add(new ArrayList(list));
            return;
        }

        //include
        list.add(nums[i]);
        dfs(i + 1, nums, ans, list);

        //exclude
        list.remove(list.size() - 1);
        dfs(i + 1, nums, ans, list); 
    }
}
