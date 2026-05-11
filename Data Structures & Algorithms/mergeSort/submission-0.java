// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSort(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> mergeSort(List<Pair> pairs, int s, int e) {
        if(e - s + 1 <= 1) return pairs;
        int m = (s + e) / 2;
        mergeSort(pairs, s, m);
        mergeSort(pairs, m + 1, e);
        return merge(pairs, s, m, e);
    }

    private List<Pair> merge(List<Pair> pairs, int s, int m, int e) {
        List<Pair> mergedList = new ArrayList<>(e - s + 1);
        int P1 = s;
        int P2 = m + 1;
        while(P1 <= m && P2 <= e) {
            if(pairs.get(P1).key <= pairs.get(P2).key) {
                mergedList.add(pairs.get(P1));
                P1++;
            } else {
                mergedList.add(pairs.get(P2));
                P2++;
            }
        }
        while(P1 <= m) {
            mergedList.add(pairs.get(P1));
            P1++;
        }
        while(P2 <= e) {
            mergedList.add(pairs.get(P2));
            P2++;
        }

        for(int i = 0; i < mergedList.size(); i++) {
            pairs.set(i + s, mergedList.get(i));
        }

        return pairs;
    }
}
