class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;
        int avg = 0;
        int N = arr.length;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        avg = sum/k;
        if(avg >= threshold) {
            count++;
        }
        int S = 1;
        int E = k;
        while(E < N) {
            sum = sum - arr[S - 1] + arr[E];
            avg = sum/k;
            if(avg >= threshold) {
                count++;
            }
            S++;
            E++;
        }
        return count;
    }
}