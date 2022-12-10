/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static final List<Integer> arr = new ArrayList();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        cumulative(n, k);
    }

    private static void cumulative(int n, int remained) {
        if (remained == 0) {
            System.out.println(String.join(" ", arr.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "))));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arr.contains(i)) {
                continue;
            }
            arr.add(i);
            cumulative(n, remained - 1);
            arr.remove(arr.size() - 1);
        }
    }
}