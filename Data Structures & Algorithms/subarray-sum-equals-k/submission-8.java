class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        int runSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            runSum += nums[i];
            prefix[i] = runSum;
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int subArraySum = Integer.MIN_VALUE;
                if(i > 0) {
                    subArraySum = prefix[j] - prefix[i - 1];
                } else {
                    subArraySum = prefix[j];
                }
                if(subArraySum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}