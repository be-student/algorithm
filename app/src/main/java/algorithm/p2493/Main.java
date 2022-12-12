package algorithm.p2493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static final Deque<Tower> deq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int current = Integer.parseInt(st.nextToken());
            if (deq.isEmpty()) {
                sb.append(0).append(' ');
                deq.addLast(new Tower(i, current));
            } else if (deq.peekLast().height == current) {
                Tower lastTower = deq.pollLast();
                sb.append(lastTower.index).append(' ');
                deq.addLast(new Tower(i, current));
            } else if (deq.peekLast().height < current) {
                while (!deq.isEmpty() && deq.peekLast().height < current) {
                    deq.pollLast();
                }
                if (deq.isEmpty()) {
                    sb.append(0).append(' ');
                } else {
                    sb.append(deq.peekLast().index).append(' ');
                }
                deq.addLast(new Tower(i, current));
            } else {
                sb.append(deq.peekLast().index).append(' ');
                deq.addLast(new Tower(i, current));
            }
        }
        System.out.println(sb);
    }
}

class Tower {

    public final int index;
    public final int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}