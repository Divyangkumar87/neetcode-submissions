class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;

        for(int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }

        for(int L = 0; L <= arr.length - k; L++) {
            sum += arr[L + k - 1];
            if(sum/k >= threshold) {
                count++;
            }
            sum -= arr[L];
        }

        /*avg = sum/k;
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
        }*/
        return count;
    }
}