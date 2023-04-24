package algorithm.leet662;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

public class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, List<Long>> map = new HashMap<>();
        dfs(root, 1, 0, map);
        long max = 0;
        for (List<Long> values : map.values()) {
            values.sort(Long::compareTo);
            long width = values.get(values.size() - 1) - values.get(0) + 1;
            max = Math.max(max, width);
        }
        return (int) max;
    }

    public void dfs(TreeNode current, int level, long index, Map<Integer, List<Long>> map) {
        if (current == null) {
            return;
        }
        if (map.containsKey(level)) {
            map.get(level).add(index);
        } else {
            List<Long> list = new ArrayList<>();
            list.add(index);
            map.put(level, list);
        }
        dfs(current.left, level + 1, index * 2, map);
        dfs(current.right, level + 1, index * 2 + 1, map);
    }
}
