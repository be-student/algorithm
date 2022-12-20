package algorithm.p8979;

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
        //금메달 수가 더 많은 나라
        //금메달 수가 같으면, 은메달 수가 더 많은 나라
        //금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
        //k번째 나라의 등수를 출력
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[][] medal = new int[n][4];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            medal[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            medal[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            medal[i][2] = Integer.parseInt(stringTokenizer.nextToken());
            medal[i][3] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int rank = 1;
        int target = 0;
        for (int i = 0; i < n; i++) {
            if (medal[i][0] == k) {
                target = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (medal[i][0] == k) {
                continue;
            }
            if (medal[i][1] > medal[target][1]) {
                rank++;
            } else if (medal[i][1] == medal[target][1]) {
                if (medal[i][2] > medal[target][2]) {
                    rank++;
                } else if (medal[i][2] == medal[target][2] && medal[i][3] > medal[target][3]) {
                    rank++;
                }
            }
        }
        sb.append(rank);

    }
}

