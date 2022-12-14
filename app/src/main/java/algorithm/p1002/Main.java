package algorithm.p1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double dist = distance(x1, y1, x2, y2);
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1).append('\n');
            } else if (Double.compare(dist, Math.abs(r1 + r2)) > 0) {
                sb.append(0).append('\n');
            } else if (Double.compare(dist, Math.abs(r2 - r1)) < 0) {
                sb.append(0).append('\n');
            } else if (Double.compare(dist, Math.abs(r2 - r1)) == 0) {
                sb.append(1).append('\n');
            } else if (Double.compare(dist, r1 + r2) == 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(2).append('\n');
            }
        }
    }

    private double distance(int x1, int y1, int x2, int y2) {
        double powDist = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        return Math.sqrt(powDist);
    }
}
