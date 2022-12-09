package algorithm.p14425;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final int NOTHING = 0;
    private static final int INSIDE = 1;

    private static final Stack<Character> stack = new Stack<>();
    private static final StringBuilder result = new StringBuilder();
    private static char[] charArray;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        charArray = br.readLine().toCharArray();
        int current = NOTHING;
        for (int i = 0; i < charArray.length; i++) {
            char temp = charArray[i];
            if (current == NOTHING) {
                if (temp == '<') {
                    current = INSIDE;
                    clearStack();
                    result.append(temp);
                    continue;
                }
                if (temp == ' ') {
                    clearStack();
                    result.append(temp);
                    continue;
                }
                stack.push(temp);
                continue;
            }
            if (temp == '>') {
                current = NOTHING;
            }
            result.append(temp);
        }
        clearStack();
        System.out.println(result);
    }

    private static void clearStack() {
        StringBuilder temp = new StringBuilder();
        while (!stack.isEmpty()) {
            temp.append(stack.pop());
        }

        result.append(temp);
    }
}
