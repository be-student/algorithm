package algorithm.p2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.reverseOrder());
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, list.get(i - 1) * i);
        }
        sb.append(max);
    }
}
