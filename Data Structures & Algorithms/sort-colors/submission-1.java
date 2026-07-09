class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for(int i = 0; i < nums.length; i++) {
            colors[nums[i]]++;
        }
        int index = 0;
        for(int i = 0; i < colors.length; i++) {
            int c = colors[i];
            for(int j = 1; j <= c; j++) {
                nums[index++] = i;
            }
        }
    }
}