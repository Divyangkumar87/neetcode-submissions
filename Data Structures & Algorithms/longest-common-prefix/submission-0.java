class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a,b) -> a.length() - b.length());
        
        String firstStr = strs[0];
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < firstStr.length(); i++) {
            char ch = firstStr.charAt(i);
            boolean isEqual = true;
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != ch) {
                    isEqual = false;
                }
            }
            if(isEqual) {
                builder.append(ch);
            } else {
                break;
            }
        }
        
        return builder.toString();
    }
}