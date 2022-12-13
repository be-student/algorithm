package algorithm.p7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> minQueue = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();
            int totalSize = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String key = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (key.equals("I")) {
                    totalSize++;
                    map.put(value, map.getOrDefault(value, 0) + 1);
                    maxQueue.offer(value);
                    minQueue.offer(value);
                } else {
                    if (totalSize <= 1) {
                        totalSize = 0;
                        maxQueue.clear();
                        minQueue.clear();
                        map.clear();
                        continue;
                    }
                    totalSize--;
                    if (value == 1) {
                        while (true) {
                            int maxValue = maxQueue.poll();
                            if (map.getOrDefault(maxValue, 0) != 0) {
                                map.put(maxValue, map.get(maxValue) - 1);
                                break;
                            }
                        }
                    } else {
                        while (true) {
                            int minValue = minQueue.poll();
                            if (map.getOrDefault(minValue, 0) != 0) {
                                map.put(minValue, map.get(minValue) - 1);
                                break;
                            }
                        }
                    }
                }
            }
            if (totalSize == 0) {
                sb.append("EMPTY").append('\n');
            } else if (totalSize == 1) {
                while (true) {
                    int maxValue = maxQueue.poll();
                    if (map.getOrDefault(maxValue, 0) != 0) {
                        map.put(maxValue, map.get(maxValue) - 1);
                        sb.append(maxValue).append(" ").append(maxValue).append('\n');
                        break;
                    }
                }
            } else {
                while (true) {
                    int maxValue = maxQueue.poll();
                    if (map.getOrDefault(maxValue, 0) != 0) {
                        sb.append(maxValue).append(' ');
                        break;
                    }
                }
                while (true) {
                    int minValue = minQueue.poll();
                    if (map.getOrDefault(minValue, 0) != 0) {
                        sb.append(minValue).append('\n');
                        break;
                    }
                }
            }

        }
    }
}
