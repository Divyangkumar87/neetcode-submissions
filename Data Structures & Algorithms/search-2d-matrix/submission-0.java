class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int L = 0;
            int R = row.length - 1;

            while(L <= R) {
                int M = L + ((R - L)/2);
                if(row[M] > target) {
                    R = M - 1;
                } else if(row[M] < target) {
                    L = M + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
