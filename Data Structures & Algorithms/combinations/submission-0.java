class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> current = new ArrayList<>();
        backtract(1, n, k, current);
        return combinations;
    }
    private void backtract(int i, int n, int k, List<Integer> current) {
        if(current.size() == k) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for(int j = i; j < n + 1; j++) {
            current.add(j);
            backtract(j + 1, n, k, current);
            current.remove(current.size() - 1);
        }
    }
}