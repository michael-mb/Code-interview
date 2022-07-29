import java.awt.desktop.AboutEvent;

public class Main {
    public static void main(String[] args) {
        char [][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {

        boolean result = true;
        for(int i = 0; i < board.length; i++){
            for(int j=0; j < board[i].length; j++){
                if(board[i][j] == '.')
                    continue;

                if(verticalSearch(board, board[i][j], j) || horizontalSearch(board[i] ,board[i][j]))
                    return false;
            }
        }

        return result;
    }

    public static boolean verticalSearch(char[][] board , char k , int pos){
        int count = 0;
        for (char[] chars : board) {
            if (chars[pos] == '.')
                continue;
            if (k == chars[pos])
                count++;
        }
        return count >= 2;
    }

    public static boolean horizontalSearch(char[] board , char k){
        int count = 0;
        for (char c : board) {
            if (c == '.')
                continue;
            if (k == c)
                count++;
        }
        return count >= 2;
    }
}