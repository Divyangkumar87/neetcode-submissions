class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0], globalMin = nums[0];
        int currMax = 0, currMin = 0, total = 0;
        for(int n : nums) {
            currMax = Math.max(currMax + n, n);
            globalMax = Math.max(currMax, globalMax);

            currMin = Math.min(currMin + n, n);
            globalMin = Math.min(currMin, globalMin);

            total += n;
        }
        return globalMax > 0 ? Math.max(globalMax, total - globalMin) : globalMax;
    }
}