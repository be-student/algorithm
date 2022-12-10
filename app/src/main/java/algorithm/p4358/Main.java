package algorithm.p4358;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        while (true) {
            String input = br.readLine();
            if (input == null || input.length() == 0) {
                break;
            }
            count++;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        List<Entry<String, Integer>> result = map.entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Entry<String, Integer> entry : result) {
            sb.append(entry.getKey())
                    .append(" ")
                    .append(String.format("%.4f", (double) 100 * entry.getValue() / count))
                    .append("\n");
        }
        System.out.println(sb);
    }
}
