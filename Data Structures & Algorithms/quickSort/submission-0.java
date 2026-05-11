// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void quickSort(List<Pair> pairs, int s, int e) {
        if(e - s + 1 <= 1) {
            return;
        }
        int left = s;
        int pivot = e;
        for(int i = s; i < e; i++) {
            if(pairs.get(i).key < pairs.get(pivot).key) {
                Collections.swap(pairs, left, i);
                left++;
            }
        }
        Collections.swap(pairs, pivot, left);
        quickSort(pairs, s, left - 1);
        quickSort(pairs, left + 1, e);
    }
    
}
