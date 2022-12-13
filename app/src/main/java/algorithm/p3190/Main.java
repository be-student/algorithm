package algorithm.p3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final boolean[][] applesMap = new boolean[101][101];
    private final boolean[][] visited = new boolean[101][101];
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            applesMap[y][x] = true;
        }
        int l = Integer.parseInt(br.readLine());
        List<Move> moves = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            moves.add(new Move(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }
        Queue<int[]> queue = new ArrayDeque<>();
        int nextMove = 0;
        Change change = new Change(n);
        visited[1][1] = true;
        queue.offer(new int[]{1, 1});
        for (int i = 1; i <= 10000; i++) {

            change.move();
            if (!change.isInRange()) {
                sb.append(i);
                return;
            }
            int[] position = change.getPosition();
            queue.offer(position);
            if (visited[position[0]][position[1]]) {
                sb.append(i);
                return;
            }
            visited[position[0]][position[1]] = true;
            if (!applesMap[position[0]][position[1]]) {
                int[] removed = queue.poll();
                visited[removed[0]][removed[1]] = false;
                applesMap[position[0]][position[1]] = false;
            }
            if (nextMove < l) {
                Move move = moves.get(nextMove);
                if (move.time == i) {
                    nextMove++;
                    if (move.turn == 'L') {
                        change.turnLeft();
                    } else {
                        change.turnRight();
                    }
                }
            }
        }
    }
}

class Move {

    public int time;
    public char turn;

    public Move(int time, char turn) {
        this.time = time;
        this.turn = turn;
    }
}

class Change {

    public final int maxSize;
    private final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final int[] position = {1, 1};
    public int currentDirection = 0;

    public Change(int maxSize) {
        this.maxSize = maxSize;
    }

    public void turnLeft() {
        currentDirection = (currentDirection + 3) % 4;
    }

    public void turnRight() {
        currentDirection = (currentDirection + 1) % 4;
    }

    public void move() {
        position[0] += direction[currentDirection][0];
        position[1] += direction[currentDirection][1];
    }

    public boolean isInRange() {
        if (position[0] == 0) {
            return false;
        }
        if (position[1] == 0) {
            return false;
        }
        if (position[0] == maxSize + 1) {
            return false;
        }
        return position[1] != maxSize + 1;
    }

    public int[] getPosition() {
        return position.clone();
    }
}