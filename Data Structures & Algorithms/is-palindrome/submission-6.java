class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            while(i < s.length() && isNonAlphaNumeric(s.charAt(i))) {
                i++;
            }
            while(j >= 0 && isNonAlphaNumeric(s.charAt(j))) {
                j--;
            }
            
            if(i >= s.length() || j < 0) continue;

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    private boolean isNonAlphaNumeric(char ch) {
        if(!(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }
}
