package algorithm.leet958;

import java.util.HashSet;
import java.util.Set;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private final Set<Integer> visited = new HashSet<>();
    private int count = 0;

    public boolean isCompleteTree(TreeNode root) {
        check(root, 1);
        for (int i = 1; i <= count; i++) {
            if (!visited.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private void check(TreeNode root, int current) {
        if (root == null) {
            return;
        }
        count++;
        visited.add(current);
        check(root.left, current * 2);
        check(root.right, current * 2 + 1);
    }
}
