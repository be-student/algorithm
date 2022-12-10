/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p5568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final List<Integer> arr = new ArrayList<>();
    private static final Set<String> set = new HashSet<>();
    private static final List<String> numbers = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            numbers.add(input);
        }
        cumulative(n, k);
        System.out.println(count);
    }

    private static void cumulative(int n, int remained) {
        if (remained == 0) {
            String result = arr.stream()
                    .map(numbers::get)
                    .collect(Collectors.joining(""));
            if (set.contains(result)) {
                return;
            }
            set.add(result);
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (arr.contains(i)) {
                continue;
            }
            arr.add(i);
            cumulative(n, remained - 1);
            arr.remove(arr.size() - 1);
        }
    }
}