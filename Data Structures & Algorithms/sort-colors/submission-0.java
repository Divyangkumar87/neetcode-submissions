class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        //[1,2,1]
        for(int i = 0; i < nums.length; i++) {
            counts[nums[i]] += 1;
        }
        int i = 0;
        for(int k = 0; k < counts.length; k++) {
            for(int j = 0; j < counts[k]; j++) {
                nums[i] = k;
                i++;
            }
        }
    }
}