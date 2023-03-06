package algorithm.leet1539;

public class Solution {

    public int findKthPositive(int[] arr, int k) {
        boolean[] visited = new boolean[2001];
        System.out.println(visited[0]);
        int count = 0;
        for (int i : arr) {
            visited[i] = true;
        }
        for (int i = 1; i <= visited.length; i++) {
            if (!visited[i]) {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }
        return -1;
    }
}
