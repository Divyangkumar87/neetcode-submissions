class Solution {
    public int findDuplicate(int[] nums) {
        int N = nums.length - 1;
        for(int num : nums) {
            int index = Math.abs(num) - 1;
            if(nums[index] < 0) {
                return Math.abs(num);
            }
            nums[index] *= -1;
        }
        return 0;
    }
}
