package algorithm.leet863;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    Map<Integer, List<Integer>> edges = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Solution().distanceK(
                new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                        new TreeNode(1, new TreeNode(0), new TreeNode(8))), new TreeNode(5), 2));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root);
        Queue<Item> queue = new ArrayDeque<>();
        queue.add(new Item(target.val, 0));
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Item poll = queue.poll();
            if (visited.contains(poll.value)) {
                continue;
            }
            visited.add(poll.value);
            if (poll.depth == k) {
                result.add(poll.value);
            }
            for (int value : edges.get(poll.value)) {
                queue.add(new Item(value, poll.depth + 1));
            }
        }
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        edges.putIfAbsent(root.val, new ArrayList<>());
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            edges.putIfAbsent(left.val, new ArrayList<>());
            edges.get(root.val)
                    .add(left.val);
            edges.get(left.val)
                    .add(root.val);
        }
        if (right != null) {
            edges.putIfAbsent(right.val, new ArrayList<>());
            edges.get(root.val)
                    .add(right.val);
            edges.get(right.val)
                    .add(root.val);
        }
        dfs(left);
        dfs(right);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Item {

    int value;
    int depth;

    public Item(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }
}
