package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        return (horizontalCheck(board) || verticalCheck(board));
    }

    public static boolean horizontalCheck(int[][] board) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 1) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == board.length) {
                result = true;
                break;
            }
            count = 0;
        }
        return result;
    }

    public static boolean verticalCheck(int[][] board) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != 1) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == board.length) {
                result = true;
                break;
            }
            count = 0;
        }
        return result;
    }
}
