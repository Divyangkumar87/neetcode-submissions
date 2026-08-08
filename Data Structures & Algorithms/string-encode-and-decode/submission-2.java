class Solution {
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String str : strs) {
            builder.append(str.length() + "#" + str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, j));
            ans.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return ans;
    }
}
