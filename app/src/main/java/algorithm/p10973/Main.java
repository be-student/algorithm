package algorithm.p10973;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        boolean isMinusOne = true;
        for (int i = 0; i < n; i++) {
            if (list.get(i) != i + 1) {
                isMinusOne = false;
                break;
            }
        }
        if (isMinusOne) {
            sb.append("-1");
            return;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                continue;
            }
            int max = i + 1;
            for (int j = i + 1; j < n; j++) {
                if (list.get(max) < list.get(j) && list.get(j) < list.get(i)) {
                    max = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(max));
            list.set(max, temp);
            List<Integer> answer = list.subList(0, i + 1);
            List<Integer> needToSort = list.subList(i + 1, n);
            answer.addAll(needToSort.stream()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList()));
            sb.append(answer.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
            break;
        }
    }
}
