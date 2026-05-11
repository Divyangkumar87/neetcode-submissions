class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> charSet = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while(j < s.length()) {
            char ch = s.charAt(j);
            while(charSet.contains(ch)) {
                charSet.remove(s.charAt(i));
                i++;
            } 
            maxLength = Math.max(maxLength, j - i + 1);
            charSet.add(ch);
            j++;
        }
        return maxLength;
    }
}
