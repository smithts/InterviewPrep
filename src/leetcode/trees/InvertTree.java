package leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            TreeNode current = nodes.remove();
            if (current.left != null) {
                nodes.add(current.left);
            }
            if (current.right != null) {
                nodes.add(current.right);
            }

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
        }

        return root;
    }

}
