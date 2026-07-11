class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        countFrequency(s, sMap);
        countFrequency(t, tMap);

        return sMap.equals(tMap);
    }
    private void countFrequency(String input, Map<Character, Integer> freqMap) {
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 0);
            }
        }
    }
}
