/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        sb.append('<');

        for (int i = 0; i < n - 1; i++) {
            rotate(k - 1);
            int temp = list.remove(0);
            sb.append(temp);
            sb.append(", ");
        }
        sb.append(list.get(0));
        sb.append(">");
        System.out.println(sb);
    }

    private static void rotate(int shift) {
        shift = shift % list.size();
        List<Integer> left = list.subList(0, shift);
        List<Integer> right = list.subList(shift, list.size());
        List<Integer> res = new ArrayList<>(right);
        res.addAll(left);
        list = res;
    }
}