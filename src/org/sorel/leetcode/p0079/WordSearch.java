package org.sorel.leetcode.p0079;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null) {
            return false;
        }

        int m = board.length, n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && search(board, flag, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, String word, int row, int col, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || word.charAt(pos) != board[row][col] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        if (search(board, visited, word, row + 1, col, pos + 1)
                || search(board, visited, word, row - 1, col, pos + 1)
                || search(board, visited, word, row, col + 1, pos + 1)
                || search(board, visited, word, row, col - 1, pos + 1)) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }
}
