class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            System.out.println(j);
            while(i <= nums.length - 1 && nums[i] != val) i++;
            while(j >= 0 && nums[j] == val) j--;
            if(i > j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        System.out.println(j);
        return j + 1;
    }
}