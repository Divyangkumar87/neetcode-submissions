class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int runSum = 0;
        for(int i = 0; i < nums.length; i++) {
            runSum += nums[i];
            prefix[i] = runSum;
        }
        runSum = 0;
        for(int i = nums.length - 1; i >= 0 ; i--) {
            runSum += nums[i];
            suffix[i] = runSum;
        }
        for(int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            if(i == 0) {
                leftSum = 0;
                rightSum = i + 1 < nums.length ? suffix[i + 1] : 0;
            } else if(i == nums.length - 1){
                leftSum = prefix[i - 1];
                rightSum = 0;
            } else {
                leftSum = prefix[i - 1];
                rightSum = i + 1 < nums.length ? suffix[i + 1] : 0;
            }
            if(leftSum == rightSum) return i;
        }
        return -1;
    }
}