/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p1620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern NUMBERS = Pattern.compile("^\\d+$");


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> name = new HashMap<>();
        Map<Integer, String> key = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String temp = br.readLine();
            name.put(temp, i);
            key.put(i, temp);
        }

        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            if (NUMBERS.matcher(temp).matches()) {
                int number = Integer.parseInt(temp);
                System.out.println(key.get(number));
                continue;
            }
            System.out.println(name.get(temp));
        }
    }
}
