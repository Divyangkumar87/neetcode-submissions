class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> combinations = new ArrayList<>();
        List<Character> current = new ArrayList<>();

        backtrack(0, digits, map, combinations, current);

        return combinations;
    }

    private void backtrack(int i, String digits, Map<Character, String> map, 
                    List<String> combinations, List<Character> current) {
        if(digits.length() == 0) return;
        if(current.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for(Character ch : current) {
                sb.append(ch);
            }
            combinations.add(sb.toString());
            return;
        }

        for(int j = i; j < digits.length(); j++) {
            String mappedChars = map.get(digits.charAt(i));
            for(int k = 0; k < mappedChars.length(); k++) {
                current.add(mappedChars.charAt(k));
                backtrack(j + 1, digits, map, combinations, current);
                current.remove(current.size() - 1);
            }
        }
    }

}
