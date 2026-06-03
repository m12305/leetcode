package hot_100.二叉树;

public class 反转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root==null){return null;}
        TreeNode temp ;
        temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
