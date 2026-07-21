class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    public int quickSelect(int[] nums, int s, int e, int k) {
        if(e - s + 1 <= 1) {
            return nums[s];
        }
        int left = s;
        int pivot = nums[e];
        for(int i = s; i < e; i++) {
            if(nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        nums[e] = nums[left];
        nums[left] = pivot;
        if(k < left) {
            return quickSelect(nums, s, left - 1, k);
        } else if(k > left) {
            return quickSelect(nums, left + 1, e, k);
        } else {
            return nums[left];
        }
    }
}
