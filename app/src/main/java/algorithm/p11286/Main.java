package algorithm.p11286;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Item> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll().item).append("\n");
                }
            } else {
                queue.offer(new Item(temp));
            }
        }
        System.out.println(sb);
    }
}

class Item implements Comparable<Item> {

    public final int item;

    public Item(int item) {
        this.item = item;
    }

    @Override
    public int compareTo(Item o) {
        if (Math.abs(item) == Math.abs(o.item)) {
            return Integer.compare(item, o.item);
        }
        return Integer.compare(Math.abs(item), Math.abs(o.item));
    }
}