package algorithm.p9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        String str = br.readLine();
        String boom = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);
            if (sb.length() >= boom.length()) {
                boolean sameFlag = true;
                for (int j = 0; j < boom.length(); j++) {
                    char ch1 = sb.charAt(sb.length() - boom.length() + j);
                    char ch2 = boom.charAt(j);
                    if (ch1 != ch2) {
                        sameFlag = false;
                        break;
                    }
                }
                if (sameFlag) {
                    sb.delete(sb.length() - boom.length(), sb.length());
                }
            }

        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
