package algorithm.leet106;

import java.util.Arrays;

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

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode tree = null;

        int length = inorder.length;

        if (length == 1) {
            return new TreeNode(inorder[0]);
        } else if (length == 0) {
            return null;
        }

        int root = postorder[length - 1];
        int leftIndex = -1;
        for (int i = 0; i < length; i++) {
            if (postorder[length - 1] == inorder[i]) {
                leftIndex = i;
                break;
            }
        }

        tree = new TreeNode(root,
                buildTree(Arrays.copyOfRange(inorder, 0, leftIndex), Arrays.copyOfRange(postorder, 0, leftIndex)),
                buildTree(Arrays.copyOfRange(inorder, leftIndex + 1, length),
                        Arrays.copyOfRange(postorder, leftIndex, length - 1)));

        return tree;
    }
}
