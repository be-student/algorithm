package algorithm.boj2615;

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
        int[][] map = new int[19][19];
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                boolean isFinish = true;
                if ((j > 0 && j < 19 - 4 && map[i][j - 1] != map[i][j]) || j == 0) {
                    for (int k = 0; k < 5; k++) {
                        if (map[i][j + k] != map[i][j]) {
                            isFinish = false;
                            break;
                        }
                    }
                    if (isFinish) {
                        if (j + 5 == 19 || (j + 5 < 19 && map[i][j + 5] != map[i][j])) {
                            sb.append(map[i][j]).append('\n').append(i + 1).append(' ').append(j + 1);
                            return;
                        }
                    }
                }
                if ((i > 0 && i < 19 - 4 && map[i - 1][j] != map[i][j]) || i == 0) {
                    isFinish = true;
                    for (int k = 0; k < 5; k++) {
                        if (map[i + k][j] != map[i][j]) {
                            isFinish = false;
                            break;
                        }
                    }
                    if (isFinish) {
                        if (i + 5 == 19 || (i + 5 < 19 && map[i + 5][j] != map[i][j])) {
                            sb.append(map[i][j]).append('\n').append(i + 1).append(' ').append(j + 1);
                            return;
                        }
                    }
                }
                if ((i > 0 && j > 0 && i < 19 - 4 && j < 19 - 4 && map[i - 1][j - 1] != map[i][j]) || i == 0
                        || j == 0) {
                    isFinish = true;
                    for (int k = 0; k < 5; k++) {
                        if (map[i + k][j + k] != map[i][j]) {
                            isFinish = false;
                            break;
                        }
                    }
                    if (isFinish) {
                        if ((i + 5 < 19 && j + 5 < 19 && map[i + 5][j + 5] != map[i][j]) || i + 5 == 19
                                || j + 5 == 19) {
                            sb.append(map[i][j]).append('\n').append(i + 1).append(' ').append(j + 1);
                            return;
                        }
                    }
                }
            }
        }
        sb.append(0);
    }
}
