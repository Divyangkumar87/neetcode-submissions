class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> unique = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
        }
        int i = 0;
        for(Integer val : unique) {
            nums[i++] = val;
        }
        return unique.size();
    }
}