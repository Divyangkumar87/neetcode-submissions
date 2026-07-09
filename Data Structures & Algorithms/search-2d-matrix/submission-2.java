class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int columns = matrix[0].length;

        for(int row = 0; row < rows; row++) {
            int l = 0;
            int r = columns - 1;

            while(l <= r) {
                int m = (l + r) / 2;
                if(matrix[row][m] == target) {
                    return true;
                }
                if(target < matrix[row][m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return false;
    }
}
