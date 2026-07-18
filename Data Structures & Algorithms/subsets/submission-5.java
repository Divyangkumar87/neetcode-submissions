class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(0, nums, subsets, current);
        return subsets;
    }

    public void dfs(int i, int[] nums, List<List<Integer>> subsets, List<Integer> current) {
        if(i > nums.length - 1) {
            subsets.add(new ArrayList(current));
            return;
        }

        //include
        current.add(nums[i]);
        dfs(i + 1, nums, subsets, current);

        //exclude
        current.remove(current.size() - 1);
        dfs(i + 1, nums, subsets, current); 
    }
}
