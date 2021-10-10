package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (horizontalCheck(board, i) || verticalCheck(board, i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean horizontalCheck(int[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean verticalCheck(int[][] board, int col) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
