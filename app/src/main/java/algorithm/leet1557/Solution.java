package algorithm.leet1557;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            result.add(i);
        }
        for (List<Integer> edge : edges) {
            result.remove(edge.get(1));
        }
        return new ArrayList<>(result);
    }
}
