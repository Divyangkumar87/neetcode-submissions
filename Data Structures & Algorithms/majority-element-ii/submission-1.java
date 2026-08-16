class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;
        List<Integer> ans = new ArrayList<>();
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            } else if(num == candidate2){
                count2++;
            } else if(count1 == 0) {
                count1 = 1;
                candidate1 = num;
            } else if(count2 == 0) {
                count2 = 1;
                candidate2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0; 
        count2 = 0;
        for(int num : nums) {
            if(num == candidate1) count1++;
            if(num == candidate2) count2++;
        }
        if(count1 > nums.length/3) ans.add(candidate1);
        if(count2 > nums.length/3) ans.add(candidate2);
        return ans;
    }
}