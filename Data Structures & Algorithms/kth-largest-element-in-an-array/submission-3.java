class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right];
        int p = left;
        for(int i = left; i < right; i++) {
            if(nums[i] <= pivot) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }
        int tmp = nums[right];
        nums[right] = nums[p];
        nums[p] = tmp;
        if(p > k) {
            return quickSelect(nums, left, p - 1, k);
        } else if(p < k) {
            return quickSelect(nums, p + 1, right, k);
        } else {
            return nums[p];
        }
    }
}
