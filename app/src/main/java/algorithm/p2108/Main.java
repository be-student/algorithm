package algorithm.p2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers.get(i);
        }
        sb.append(Math.round((double) sum / n)).append('\n');
        Collections.sort(numbers);
        sb.append(numbers.get(n / 2)).append('\n');
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int temp = numbers.get(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            maxCount = Math.max(maxCount, map.get(temp));
        }
        int finalMaxCount = maxCount;
        List<Integer> list = map.entrySet().stream()
                .filter(it -> it.getValue() == finalMaxCount)
                .map(Entry::getKey)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        if (list.size() > 1) {
            sb.append(list.get(1)).append('\n');
        } else {
            sb.append(list.get(0)).append('\n');
        }
        sb.append(numbers.get(n - 1) - numbers.get(0)).append('\n');
    }
}
