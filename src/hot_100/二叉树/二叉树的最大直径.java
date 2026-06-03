package hot_100.二叉树;

public class 二叉树的最大直径 {

    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node) {
        if (node == null) {return 0;}
        int lLen = dfs(node.left);
        int rLen = dfs(node.right);
        ans = Math.max(ans, lLen + rLen); // 两条链拼成路径
        return Math.max(lLen, rLen) + 1;
    }

}
