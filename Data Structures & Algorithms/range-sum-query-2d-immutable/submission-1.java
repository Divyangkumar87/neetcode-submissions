class NumMatrix {
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            prefix[i][0] = matrix[i][0];
            for(int j = 1; j < matrix[i].length; j++) {
                prefix[i][j] = prefix[i][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int r = row1; r <= row2; r++) {
            if(col1 > 0) {
                ans += prefix[r][col2] - prefix[r][col1 - 1];
            } else {
                ans += prefix[r][col2];
            }
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */