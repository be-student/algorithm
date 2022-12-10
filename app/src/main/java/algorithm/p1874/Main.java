/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> st = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        int current = 1;
        for (int T = 0; T < n; T++) {
            int target = Integer.parseInt(br.readLine());
            if (st.peekLast() != null && st.peekLast() == target) {
                st.pollLast();
                result.append("-").append("\n");
                continue;
            }
            for (int i = current; i <= n; i++) {
                st.addLast(i);
                current++;
                result.append("+").append("\n");
                if (st.peekLast() != null && st.peekLast() == target) {
                    result.append("-").append("\n");
                    st.pollLast();
                    break;
                }
            }
        }
        String log = result.toString();
        if (log.chars().filter(it -> it == '-').count() != n) {
            System.out.println("NO");
            return;
        }
        System.out.println(log);
    }
}