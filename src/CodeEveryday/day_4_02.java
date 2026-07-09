package CodeEveryday;

public class day_4_02 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param board string字符串一维数组
     * @param word string字符串
     * @return bool布尔型
     */
    public boolean exist(String[] strs, String word) {
        char[][] board = new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; i++) board[i] = strs[i].toCharArray();
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[0].length(); j++) {
                if (dfs(board, word.toCharArray(), i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 ||
                board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
