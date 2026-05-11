class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
         UnionFind uf = new UnionFind(accounts.size());
         Map<String, Integer> emailToAccountId = new HashMap<>();

         for(int i = 0; i < accounts.size(); i++) {
            List<String> account =  accounts.get(i);
            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(emailToAccountId.containsKey(email)) {
                    uf.unionByRank(i, emailToAccountId.get(email));
                } else {
                    emailToAccountId.put(email, i);
                }
            }
         }

         Map<Integer, List<String>> unionedSets = new HashMap<>();
         for(String email : emailToAccountId.keySet()) {
            int accountId = emailToAccountId.get(email);
            int leader = uf.find(accountId);
            if(unionedSets.containsKey(leader)) {
                unionedSets.get(leader).add(email);
            } else {
                List<String> emailAddresses = new ArrayList<>();
                emailAddresses.add(email);
                unionedSets.put(leader, emailAddresses);
            }
         }

         List<List<String>> ans = new ArrayList<>();
         for(Integer leader : unionedSets.keySet()) {
            List<String> emails = unionedSets.get(leader);
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(leader).get(0));
            merged.addAll(emails);
            ans.add(merged);
         }
         return ans;
    }
}
class UnionFind {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> rank;
    public UnionFind(int n) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        for(int i = 0; i < n; i++) {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }
    int find(int n) {
        int p = parent.get(n);
        while(p != parent.get(p)) {
            parent.put(p, parent.get(parent.get(p))); //path compresssion
            p = parent.get(p);
        }
        return p;
    }
    boolean unionByRank(int n1, int n2) {
        int p1 = this.find(n1);
        int p2 = this.find(n2);
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
}