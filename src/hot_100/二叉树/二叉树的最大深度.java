package hot_100.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root==null){return 0;}
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
