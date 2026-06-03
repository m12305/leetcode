package hot_100.二叉树;

import java.util.ArrayList;
import java.util.List;

public class 中序遍历 {
    List<Integer> re = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){return re;}
        if(root.left!=null){inorderTraversal(root.left);}
        re.add(root.val);
        if(root.right!=null){inorderTraversal(root.right);}
        return re;
    }
}
