package algorithm.leet1345;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int result = solution.minJumps(arr);
        System.out.println(result);
    }

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        queue.offer(0);
        visited.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (index == n - 1) {
                    return step;
                }
                List<Integer> list = map.get(arr[index]);
                list.add(index - 1);
                list.add(index + 1);
                for (int next : list) {
                    if (next >= 0 && next < n && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
                list.clear();
            }
            step++;
        }
        return 0;
    }
}
