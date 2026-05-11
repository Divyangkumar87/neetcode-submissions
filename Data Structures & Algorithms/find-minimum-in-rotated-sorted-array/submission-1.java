class Solution {
    public int findMin(int[] nums) {

        int L = 0;
        int R = nums.length - 1;
        int res = Integer.MAX_VALUE;
        
        while(L <= R) {
            if(nums[L] <= nums[R]) {
                res = Math.min(res, nums[L]);
                break;
            }
            int M = (L + R) / 2; //(L + (R - L))/2
            if(nums[L] <= nums[M]) {
                res = Math.min(res, nums[L]);
                L = M + 1;
            } else {
                res = Math.min(res, nums[M]);
                R = M - 1;
            }
        }
        return res;
    }
}
