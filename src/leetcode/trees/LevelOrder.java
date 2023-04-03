package leetcode.trees;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            result.add(Collections.singletonList(root.val));

            while (!queue.isEmpty()) {
                int levels = queue.size();
                List<Integer> currentLevel = new ArrayList<>();

                for (int i = 0; i < levels; i++) {
                    TreeNode current = queue.remove();

                    if (current.left != null) {
                        queue.add(current.left);
                        currentLevel.add(current.left.val);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                        currentLevel.add(current.right.val);
                    }
                }

                if (!currentLevel.isEmpty()) {
                    result.add(currentLevel);
                }
            }
        }

        return result;
    }

}
