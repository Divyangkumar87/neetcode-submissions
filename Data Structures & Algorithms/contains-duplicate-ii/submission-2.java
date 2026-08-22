class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0;
        int R = 0;
        Set<Integer> set = new HashSet<>();
        while(R < nums.length) {
            if(Math.abs(L - R) > k) {
                set.remove(nums[L]);
                L++;
            }
            if(set.contains(nums[R])) return true;
            set.add(nums[R]);
            R++;
        }
        return false;
    }
}