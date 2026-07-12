class Solution {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs, (a,b) -> a.length() - b.length());
        String firstStr = strs[0];

        for(int i = 0; i < firstStr.length(); i++) {
            char ch = firstStr.charAt(i);
            int j = 1;
            while(j < strs.length) {
                if(strs[j].charAt(i) != ch) {
                    return firstStr.substring(0, i);
                }
                j++;
            }
        }
        return firstStr;
    }
}