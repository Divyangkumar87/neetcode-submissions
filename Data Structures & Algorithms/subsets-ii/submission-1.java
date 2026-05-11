class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0, nums, current, subsets);
        return subsets;
    }
    private void subsets(int i, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        if(i >= nums.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        subsets(i + 1, nums, current, subsets);
        current.remove(current.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        subsets(i + 1, nums, current, subsets);
    }
}
