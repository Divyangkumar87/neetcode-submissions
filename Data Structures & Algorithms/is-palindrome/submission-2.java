class Solution {
    public boolean isPalindrome(String s) {
        int L = 0;
        int R = s.length() - 1;
        while(L < R) {
            while(L < R && !isAlphaNumeric(s.charAt(L))) {
                L++;
            }
            while(R > L && !isAlphaNumeric(s.charAt(R))) {
                R--;
            }
            if(Character.toLowerCase(s.charAt(L)) != Character.toLowerCase(s.charAt(R))) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }
    private boolean isAlphaNumeric(char ch) {
        if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }
}
