class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 0, max = 0;
        if(nums.length <= 1) return nums.length;
        for(int i = nums.length - 2; i >= 0; i--) {
           if(nums[i + 1] == nums[i]) continue;  
           if(nums[i + 1] - nums[i] == 1) {
                count++;
           } else {
                count = 0;
           }
           max = Math.max(count, max);
        }
        return max + 1;
    }
}