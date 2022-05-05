package com.leetcode.p0079;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && search(board, flag, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || word.charAt(pos) != board[i][j] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (search(board, visited, word, i + 1, j, pos + 1)
                || search(board, visited, word, i - 1, j, pos + 1)
                || search(board, visited, word, i, j + 1, pos + 1)
                || search(board, visited, word, i, j - 1, pos + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
