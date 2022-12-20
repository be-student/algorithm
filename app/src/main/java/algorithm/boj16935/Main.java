package algorithm.boj16935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int[][] arr;

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] order = new int[r];
        for (int i = 0; i < r; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            switch (order[i]) {
                case 1:
                    reverseTopBottom();
                    break;
                case 2:
                    reverseLeftRight();
                    break;
                case 3:
                    rotateRight();
                    break;
                case 4:
                    rotateLeft();
                    break;
                case 5:
                    rotateAllRight();
                    break;
                case 6:
                    rotateAllLeft();
                    break;

            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }

    }

    private void rotateAllLeft() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                result[i + n / 2][j] = arr[i][j];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                result[i][j] = arr[i][j + m / 2];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                result[i][j + m / 2] = arr[i + n / 2][j + m / 2];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                result[i + n / 2][j + m / 2] = arr[i + n / 2][j];
            }
        }
        arr = result;
    }

    private void rotateAllRight() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                result[i][j + m / 2] = arr[i][j];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                result[i + n / 2][j + m / 2] = arr[i][j + m / 2];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                result[i + n / 2][j] = arr[i + n / 2][j + m / 2];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                result[i][j] = arr[i + n / 2][j];
            }
        }
        arr = result;
    }


    private void reverseLeftRight() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][m - j - 1] = arr[i][j];
            }
        }
        arr = result;
    }

    private void reverseTopBottom() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[n - i - 1][j] = arr[i][j];
            }
        }
        arr = result;
    }

    //원본 배열 arr의 크기 n,m을 받고, 배열 arr을 오른쪽 90도 회전
    private void rotateRight() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = arr[i][j];
            }
        }
        arr = result;
    }

    private void rotateLeft() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[m - j - 1][i] = arr[i][j];
            }
        }
        arr = result;
    }
}
