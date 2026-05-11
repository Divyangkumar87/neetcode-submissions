class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(0, nums, permutations);
        return permutations;
    }
    private void permute(int i, int[] nums, List<List<Integer>> permutations) {
        if(i == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for(int n : nums) {
                curr.add(n);
            }
            permutations.add(curr);
            return;
        }
        for(int j = i; j < nums.length; j++) {
            swap(i, j, nums);
            permute(i + 1, nums, permutations);
            swap(i, j, nums);
        }
    }
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
