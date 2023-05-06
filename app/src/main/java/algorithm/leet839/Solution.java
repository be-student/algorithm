package algorithm.leet839;

public class Solution {

    int[] root = new int[500];

    public int numSimilarGroups(String[] strs) {
        for (int i = 0; i < 500; i++) {
            root[i] = i;
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < strs.length; i++) {
            if (root[i] == i) {
                answer++;
            }
        }
        return answer;
    }

    boolean isSimilar(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        return true;
    }

    /* find(x): 재귀 이용 */
    int find(int x) {
        // 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
        if (root[x] == x) {
            return x;
        } else {
            // 각 노드의 부모 노드를 찾아 올라간다.
            return find(root[x]);
        }
    }

    /* union(x, y) */
    void union(int x, int y) {
        // 각 원소가 속한 트리의 루트 노드를 찾는다.
        x = find(x);
        y = find(y);

        root[y] = x;
    }
}
