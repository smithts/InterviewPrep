package leetcode.trees;

public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root!= null) {
            return maxDepth(root, 0);
        } else {
            return 0;
        }
    }

    public int maxDepth(TreeNode current, int depth) {
        if (current.left == null && current.right == null) {
            return depth + 1;
        }
        if (current.left == null && current.right != null) {
            return maxDepth(current.right, depth + 1);
        }
        if (current.left != null && current.right == null) {
            return maxDepth(current.left, depth + 1);
        }

        return Math.max(maxDepth(current.left, depth + 1), maxDepth(current.right, depth + 1));
    }

}

