class Solution {
    public int[] getConcatenation(int[] nums) {
        int N = nums.length;
        int[] ans = new int[2*N];
        for(int i = 0; i < 2*N ; i++) {
            if(i >= N) {
                ans[i] = nums[i - N];
            } else {
                ans[i] = nums[i];
            }
        }
        return ans;
    }
}