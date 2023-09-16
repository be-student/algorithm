package algorithm.boj10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int T = Integer.parseInt(s);
        Stck stck = new Stck();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String s1 = br.readLine();
            String[] strings = s1.split(" ");
            if (strings[0].equals("push")) {
                stck.push(Integer.parseInt(strings[1]));
            } else if (strings[0].equals("top")) {
                sb.append(stck.top())
                        .append("\n");
            } else if (strings[0].equals("size")) {
                sb.append(stck.size())
                        .append("\n");
            } else if (strings[0].equals("empty")) {
                sb.append(stck.empty())
                        .append("\n");
            } else {
                sb.append(stck.pop())
                        .append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}

class Stck {

    LinkedList<Integer> linkedList = new LinkedList<>();

    void push(int n) {
        linkedList.add(n);
    }

    int top() {
        if (linkedList.isEmpty()) {
            return -1;
        }
        return linkedList.getLast();
    }

    int size() {
        return linkedList.size();
    }

    int empty() {
        return linkedList.isEmpty() ? 1 : 0;
    }

    int pop() {
        if (linkedList.isEmpty()) {
            return -1;
        }
        return linkedList.removeLast();
    }
}
