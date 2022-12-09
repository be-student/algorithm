package algorithm.p13335;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static final Deque<Truck> deque = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int bridgeLength = Integer.parseInt(st.nextToken());
        int availableWeight = Integer.parseInt(st.nextToken());
        int totalWeight = 0;
        int currentTime = 1;
        st = new StringTokenizer(br.readLine(), " ");
        int[] trucks = new int[n];
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st.nextToken());
            trucks[i] = weight;
        }
        for (int i = 0; i < n; ) {
            while (!deque.isEmpty()) {
                Truck first = deque.peekFirst();
                if (first.endTime <= currentTime) {
                    deque.pollFirst();
                    totalWeight -= first.weight;
                    continue;
                }
                break;
            }
            int nowWeight = trucks[i];
            if (availableWeight >= totalWeight + nowWeight) {
                totalWeight += nowWeight;
                deque.addLast(new Truck(currentTime + bridgeLength, nowWeight));
                currentTime++;
                i++;
                continue;
            }
            Truck first = deque.pollFirst();
            currentTime = first.endTime;
            totalWeight -= first.weight;
        }
        System.out.println(deque.pollLast().endTime);
    }
}

class Truck {

    public final int endTime;
    public final int weight;

    public Truck(int endTime, int weight) {
        this.endTime = endTime;
        this.weight = weight;
    }
}