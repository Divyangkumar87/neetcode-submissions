class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int maxCount = Integer.MIN_VALUE;
        int majorityElement = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;
            } else {
                count--;
            }
            if(count > maxCount) {
                maxCount = count;
                majorityElement = nums[i];
            }
        }
        return majorityElement;
    }
}