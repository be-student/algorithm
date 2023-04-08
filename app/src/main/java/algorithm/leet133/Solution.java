package algorithm.leet133;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {

    public static void main(String[] args) {
        //[[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node2.neighbors = List.of(node4, node3);
        node1.neighbors = List.of(node2, node4);
        node3.neighbors = List.of(node2, node4);
        node4.neighbors = List.of(node1, node3);
        System.out.println(new Solution().cloneGraph(node1));
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (!nodes.containsKey(current.val)) {
                nodes.put(current.val, new HashSet<>());
            }
            for (Node neighbor : current.neighbors) {
                nodes.get(current.val).add(neighbor.val);
                if (!nodes.containsKey(neighbor.val)) {
                    queue.add(neighbor);
                }
            }
        }
        Map<Integer, Node> clones = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> entry : nodes.entrySet()) {
            clones.put(entry.getKey(), new Node(entry.getKey()));
        }
        for (Map.Entry<Integer, Set<Integer>> entry : nodes.entrySet()) {
            for (Integer neighbor : entry.getValue()) {
                clones.get(entry.getKey()).neighbors.add(clones.get(neighbor));
            }
        }
        return clones.get(node.val);
    }
}
