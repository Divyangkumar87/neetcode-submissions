class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        if(s.length() != t.length()) return false;
        charFrequency(sMap, s);
        charFrequency(tMap, t);
        return sMap.equals(tMap);
    }
    private void charFrequency(Map<Character, Integer> freqMap, String str) {
        for(char ch : str.toCharArray()) {
            if(freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
               freqMap.put(ch, 1); 
            }
        }
    }
}
