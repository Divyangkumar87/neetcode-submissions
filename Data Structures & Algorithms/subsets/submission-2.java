class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        subsets(0, nums, current, subsets);
        return subsets;
    }
    private void subsets(int i, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        //base case
        if(i >= nums.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        //include
        current.add(nums[i]);
        subsets(i + 1, nums, current, subsets);

        //exclude
        current.remove(current.size() - 1);
        subsets(i + 1, nums, current, subsets);
    }

}
