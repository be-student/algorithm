package algorithm.prognext4;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Solution {

    public static void main(String[] args) {

        // result 5, 4, 3
        System.out.println(Arrays.toString(new Solution().solution(3,
                new String[]{"1", "2", "3", "4", "5"})));
    }

    public String[] solution(int maxSize, String[] actions) {
        LinkedHashSet<Integer> visited = new LinkedHashSet<>();
        LinkedHashSet<Integer> backward = new LinkedHashSet<>();
        LinkedHashSet<Integer> forward = new LinkedHashSet<>();

        for (String action : actions) {
            if (!action.equals("B") && !action.equals("F")) {
                int number = Integer.parseInt(action);
                visited.add(number);
                backward.add(number);
                forward.clear();
            } else if (action.equals("B")) {
                if (backward.isEmpty()) {
                    continue;
                }
                Integer last = backward.iterator()
                        .next();
                backward.remove(last);
                visited.add(last);
                forward.add(last);
            } else if (action.equals("F")) {
                if (forward.isEmpty()) {
                    continue;
                }
                Integer first = forward.iterator()
                        .next();
                forward.remove(first);
                visited.add(first);
                backward.add(first);
            }
        }

        int size = Math.min(maxSize, visited.size());
        String[] answer = new String[size];
        int index = 0;

        // Reverse the order of elements in the visited set
        Integer[] reversedVisited = visited.toArray(new Integer[visited.size()]);
        for (int i = size - 1; i >= 0; i--) {
            answer[index++] = reversedVisited[i].toString();
        }

        return answer;
    }
}
