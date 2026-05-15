class Solution {
    public boolean isValid(String s) {
        
        Map<Character, Character> pairs = new HashMap();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!stack.isEmpty() && pairs.containsKey(ch)) {
                char stackCh = stack.pop();
                if(stackCh != pairs.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

