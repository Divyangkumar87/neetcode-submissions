class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder build = new StringBuilder();
        
        int i = 0;
        int j = 0;

        while(i < word1.length() && j < word2.length()) {
            build.append(word1.charAt(i)).append(word2.charAt(j));
            i++;
            j++;
        }

        while(i < word1.length()) {
            build.append(word1.charAt(i));
            i++;
        }

        while(j < word2.length()) {
            build.append(word2.charAt(j));
            j++;
        }

        return build.toString();
    }
}