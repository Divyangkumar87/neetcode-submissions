class Solution {
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for(int i = 1; i <= n; i++) {
            parent.put(i, i);
            rank.put(i, 0);
        }
        for(int i = 0; i < n; i++) {
            if(!unionByRank(edges[i][0],edges[i][1])) {
                return edges[i];
            } 
        }
        return new int[]{};
    }
    public boolean unionByRank(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return false;
        if(rank.get(p1) > rank.get(p2)) {
            parent.put(p2, p1);
        } else if(rank.get(p2) > rank.get(p1)) {
            parent.put(p1, p2);
        } else {
            parent.put(p1, p2);
            rank.put(p2, rank.get(p2) + 1);
        }
        return true;
    }
    public int find(int n) {
        int p = parent.get(n);
        while(p != parent.get(p)) {
            parent.put(p, parent.get(parent.get(p)));
            p = parent.get(p);
        }
        return p;
    }
}
