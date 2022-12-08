/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p2776;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final String ONE = "1\n";
    private static final String ZERO = "0\n";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TEST = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < TEST; T++) {
            Set<Integer> set = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer nToken = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int item = Integer.parseInt(nToken.nextToken());
                set.add(item);
            }
            String line = br.readLine();
            int m = Integer.parseInt(line);
            StringTokenizer mToken = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < m; i++) {
                int item = Integer.parseInt(mToken.nextToken());
                if (set.contains(item)) {
                    sb.append(ONE);
                    continue;
                }
                sb.append(ZERO);
            }

        }
        System.out.println(sb.toString());
    }
}
