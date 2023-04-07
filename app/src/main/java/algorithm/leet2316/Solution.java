package algorithm.leet2316;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    private final List<Integer> parent = new ArrayList<>();

    private void union(int a, int b) {
        parent.set(b, a);
    }

    private int findParent(int index) {
        if (parent.get(index) == index) {
            return index;
        }
        int newParent = findParent(parent.get(index));
        parent.set(index, newParent);
        return newParent;
    }

    public long countPairs(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
        }
        for (var edge : edges) {
            var a = findParent(edge[0]);
            var b = findParent(edge[1]);
            union(a, b);
        }
        for (int i = 0; i < n; i++) {
            findParent(i);
        }
        Map<Integer, Long> result = parent.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Long> list = new ArrayList<>(result.values());
        long ans = 0;
        long count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            count += list.get(i);
            ans += count * list.get(i + 1);
        }

        return ans;
    }
}
