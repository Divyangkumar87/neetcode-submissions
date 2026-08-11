class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> columnSet = new HashSet<>();
        return checkRow(board, rowSet) && checkColumn(board, columnSet) && checkMatricies(board);
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

    private boolean checkMatricies(char[][] board) {
        for(int square  = 0; square < 3; square++) {
            int startRow = (square / 3) * 3;
            int startColumn = (square % 3) * 3;
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int row = startRow + i;
                    int column = startColumn + j;
                    char ch = board[row][column];
                    if(ch == '.') continue;
                    if(seen.contains(ch)) return false;
                    seen.add(ch);
                }
            }
        }
        return true;
    }
}
