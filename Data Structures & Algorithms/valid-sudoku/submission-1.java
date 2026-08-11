class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> columnSet = new HashSet<>();
        Set<Character> subMatrix1 = new HashSet<>();
        Set<Character> subMatrix2 = new HashSet<>();
        Set<Character> subMatrix3 = new HashSet<>();

        boolean row = checkRow(board, rowSet);
        boolean column = checkColumn(board, columnSet);
        boolean subMatrices = checkSubMatrix(board, subMatrix1, subMatrix2, subMatrix3);

        System.out.println("Row :" + row);
        System.out.println("column :" + column);
        System.out.println("subMatrices :" + subMatrices);

        return row && column && subMatrices;
    }
    private boolean checkRow(char[][] board, Set<Character> rowSet) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                char ch = board[r][c];
                if(ch == '.') continue;
                if(rowSet.contains(ch)) return false;
                rowSet.add(ch);
            }
            rowSet.clear();
        }
        return true;
    }
    private boolean checkColumn(char[][] board, Set<Character> columnSet) {
        for(int c = 0; c < board[0].length; c++) {
            for(int r = 0; r < board.length; r++) {
                char ch = board[r][c];
                if(ch == '.') continue;
                if(columnSet.contains(ch)) return false;
                columnSet.add(ch);
            }
            columnSet.clear();
        }
        return true;
    }
    private boolean checkSubMatrix(char[][] board, Set<Character> subMatrix1, 
                        Set<Character> subMatrix2, Set<Character> subMatrix3) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                char ch = board[r][c];
                if(ch == '.') continue;
                if(c < 3) {
                    if(subMatrix1.contains(ch)) return false;
                    subMatrix1.add(ch);
                } else if(c > 2 && c < 6) {
                    if(subMatrix2.contains(ch)) return false;
                    subMatrix2.add(ch);
                } else {
                    if(subMatrix3.contains(ch)) return false;
                    subMatrix3.add(ch);
                }
            }
            if(r == 2 || r == 5) {
                subMatrix1.clear();
                subMatrix2.clear();
                subMatrix3.clear();
            }
        }
        return true;
    }
}
