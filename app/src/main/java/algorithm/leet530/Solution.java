package algorithm.leet530;

import java.util.ArrayList;
import java.util.List;

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

public class Solution {

    List<Integer> nums = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        nums.sort(Integer::compareTo);
        int ans = nums.get(1) - nums.get(0);
        for (int i = 0; i < nums.size() - 1; i++) {
            ans = Math.min(ans, nums.get(i + 1) - nums.get(i));
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        nums.add(root.val);
        dfs(root.right);
    }
}
