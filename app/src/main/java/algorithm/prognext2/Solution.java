package algorithm.prognext2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    Map<Integer, Set<Integer>> edges = new HashMap<>();
    Set<Integer> firstFriend = new HashSet<>();
    Set<Integer> newFriends = new HashSet<>();

//    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 2, 3));
//    }

    public int solution(int[][] relationships, int target, int limit) {
        int answer = 0;
        for (int[] relationShip : relationships) {
            edges.putIfAbsent(relationShip[0], new HashSet<>());
            edges.get(relationShip[0])
                    .add(relationShip[1]);
            edges.putIfAbsent(relationShip[1], new HashSet<>());
            edges.get(relationShip[1])
                    .add(relationShip[0]);
        }
        Set<Integer> integers = edges.get(target);
        int size = integers.size();
        answer += 5 * size;
        integers.add(target);

        bfs(target, limit, 0);

        newFriends.remove(target);

        newFriends.removeAll(integers);

        answer += 10 * newFriends.size();

        answer += newFriends.size();
        return answer;
    }

    private void bfs(int target, int limit, int i) {
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(target, 0));
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.depth == limit) {
                continue;
            }
            Set<Integer> integers = edges.get(item.current);
            for (Integer integer : integers) {
                if (newFriends.contains(integer)) {
                    continue;
                }
                newFriends.add(integer);
                queue.add(new Item(integer, item.depth + 1));
            }
        }

    }
}

class Item {

    int current;
    int depth;

    public Item(int current, int depth) {
        this.current = current;
        this.depth = depth;
    }
}
