class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        int n = nums.length;
        while(r < n) {
            if(nums[r] != val) {
                nums[l] = nums[r];
                l++;
            } 
            r++;
        }
        return l;
    }
}