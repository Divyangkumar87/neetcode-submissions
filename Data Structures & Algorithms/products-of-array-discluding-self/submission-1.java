class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int N = nums.length;

        int[] pref = new int[N];
        int[] suff = new int[N];

        pref[0] = 1;
        suff[N - 1] = 1;

        for(int i = 1; i < N; i++) {
            pref[i] = pref[i - 1] * nums[i - 1];
        }

        for(int i = N - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < N; i++) {
            pref[i] = pref[i] * suff[i];
        }

        return pref;
    }
}  
