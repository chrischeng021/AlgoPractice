public class BinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (null == root)
            return 0;
        if (null == root.left && null == root.right)
            return 1;

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    // 合并二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(null == t1)
            return t2;
        if(null == t2)
            return t1;
        TreeNode res = new TreeNode(t1.val + t2.val);
        res.left = mergeTrees(t1.left, t2.left);
        res.right = mergeTrees(t1.right, t2.right);

        return res;
    }

    // 对称二叉树
    // 递归解法
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode r1, TreeNode r2){
        if(null == r1 && null == r2)
            return true;
        if(null == r1 || null == r2)
            return false;
        return r1.val == r2.val && isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }
}

