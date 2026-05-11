class Solution {
    public int search(int[] nums, int target) {
        
        int L = 0;
        int R = nums.length - 1;

        while(L <= R) {
            int M = L + ((R - L) / 2);
            if(nums[M] > target) {
                R = M - 1;
            } else if(nums[M] < target) {
                L = M + 1;
            } else {
                return M;
            }
        }

        return -1;

    }
}
