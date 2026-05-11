class Solution {
    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while(L <= R) {
            int M = (L + R) /2;
            if(nums[M] == target) {
                return M;
            }
            //Left sorted portion
            if(nums[L] <= nums[M]) {
                if(target < nums[L] || target > nums[M]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            // right sorted portion
            } else {
                if(target > nums[R] || target < nums[M]) {
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            }
        }
        return -1;
    }
}
