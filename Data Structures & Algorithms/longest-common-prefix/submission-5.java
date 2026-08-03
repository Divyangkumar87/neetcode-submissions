class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        String firstStr = strs[0];
        for(int i = 0; i < firstStr.length(); i++) {
            char ch = firstStr.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(ch != strs[j].charAt(i)) {
                    return firstStr.substring(0, i);
                }
            }
        }
        return firstStr;
    }
}