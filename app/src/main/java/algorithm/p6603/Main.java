package algorithm.p6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final List<Integer> list = new ArrayList<>();
    private final List<Integer> choosen = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                return;
            }

            list.clear();
            choosen.clear();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            shuffle(0, n);
            sb.append('\n');
        }
    }

    private void shuffle(int start, int end) {
        if (start == end) {
            sb.append(list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "))).append('\n');
            return;
        }
//        for (int i = start; i < end; i++) {
//            swap(start, i);
//            shuffle(start + 1, end);
//            swap(start, i);
//        }
        for (int i = start; i < end; i++) {
            choosen.add(list.get(i));
            shuffle(start + 1, end);
            choosen.remove(choosen.size() - 1);
        }
    }

//    private void swap(int i, int j) {
//        int temp = list.get(i);
//        list.set(i, list.get(j));
//        list.set(j, temp);
//    }
}
