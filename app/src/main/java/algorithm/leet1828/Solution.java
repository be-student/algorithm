package algorithm.leet1828;

class Solution {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (powDist(points[j], queries[i]) <= queries[i][2] * queries[i][2]) {
                    result[i]++;
                }
            }
        }
        return result;
    }

    private int powDist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}