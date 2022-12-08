/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p17219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final List<Integer> arr = new ArrayList();
    private static final Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            String site = input.nextToken();
            String pass = input.nextToken();
            map.put(site, pass);
        }

        for (int i = 0; i < k; i++) {
            String input = br.readLine();
            sb.append(map.get(input)).append("\n");
        }
        System.out.println(sb);
    }
}
