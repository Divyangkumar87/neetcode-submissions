class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsets(0, nums, current, subsets);
        return subsets;
    }
    private void subsets(int i, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        if(i >= nums.length) {
            List<Integer> temp = new ArrayList<>(current);
            Collections.sort(temp);
            if(!subsets.contains(temp)) {
                subsets.add(temp);
            }
            return;
        }

        current.add(nums[i]);
        subsets(i + 1, nums, current, subsets);

        current.remove(current.size() - 1);
        subsets(i + 1, nums, current, subsets);
    }
}
