package algorithm.leet129;

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

    private int result = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode current, int now) {
        if (current.left == null && current.right == null) {
            result += now * 10 + current.val;
            return;
        }
        if (current.left != null) {
            dfs(current.left, now * 10 + current.val);
        }
        if (current.right != null) {
            dfs(current.right, now * 10 + current.val);
        }
    }
}
