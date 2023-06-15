package algorithm.leet1161;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> sumList = new ArrayList<>();

    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        int ans = 0;
        for (int i = 1; i < sumList.size(); i++) {
            if (sumList.get(i) > sumList.get(ans)) {
                ans = i;
            }
        }
        return ans + 1;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (sumList.size() <= level) {
            sumList.add(root.val);
        } else {
            sumList.set(level, sumList.get(level) + root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}

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
