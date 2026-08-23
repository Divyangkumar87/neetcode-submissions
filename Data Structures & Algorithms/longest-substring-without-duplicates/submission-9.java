class Solution {
    public int lengthOfLongestSubstring(String s) {
        int L = 0;
        int R = 0;
        Set<Character> set = new HashSet<>();
        int length = 0;
        while(R < s.length()) {
            while(set.contains(s.charAt(R))) {
                set.remove(s.charAt(L));
                L++;
            }
            length = Math.max(length, R - L + 1);
            set.add(s.charAt(R));
            R++;
        }
        return length;
    }
}
