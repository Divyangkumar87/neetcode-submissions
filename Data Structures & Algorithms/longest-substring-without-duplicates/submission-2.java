class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int length = 0;

        while(right < s.length()) {
            char ch = s.charAt(right);
            while(set.contains(ch) && left < s.length()) {
                set.remove(s.charAt(left));
                left++;
            }
            length = Math.max(length, right - left + 1);
            set.add(ch);
           /* if(set.isEmpty()) {
                right = left + 1;
            } else {
                right++;
            }*/
            right++;
        }

        return length;
    }
}
