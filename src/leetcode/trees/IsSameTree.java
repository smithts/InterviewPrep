package leetcode.trees;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            //both nodes are null
            return true;
        } else if (p == null || q == null) {
            //only one node is null
            return false;
        } else if (p.val == q.val) {
            //nodes are the same, continue  checking for similarity
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}


