class NumMatrix {
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            int runSum = 0;
            for(int j = 0; j < matrix[0].length; j++) {
                runSum += matrix[i][j];
                prefix[i][j] = runSum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = 0;
        for(int i = row1; i <= row2; i++) {
            if(col1 > 0) {
                total += prefix[i][col2] - prefix[i][col1 - 1];
            } else {
                total += prefix[i][col2];
            }
        }
        return total;
    }
}