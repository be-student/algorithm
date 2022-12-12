package algorithm.p1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> first = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            first.add(Integer.parseInt(st.nextToken()));
        }
        first.sort(Comparator.naturalOrder());

        List<Integer> second = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            second.add(Integer.parseInt(st.nextToken()));
        }
        second.sort(Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += first.get(i) * second.get(i);
        }
        sb.append(sum);
    }
}
