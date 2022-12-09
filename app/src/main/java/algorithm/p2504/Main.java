package algorithm.p2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final Stack<Character> stack = new Stack<>();
    private static char[] chars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chars = br.readLine().toCharArray();
        int result = 0;
        int temp = 1;
        boolean needsToAdd = true;
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(aChar);
                temp *= 2;
                needsToAdd = true;
            } else if (aChar == '[') {
                stack.push(aChar);
                temp *= 3;
                needsToAdd = true;
            } else if (aChar == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if (needsToAdd) {
                    needsToAdd = false;
                    result += temp;
                }
                temp /= 2;
            } else if (aChar == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if (needsToAdd) {
                    needsToAdd = false;
                    result += temp;
                }
                temp /= 3;
            }
        }
        if (!stack.isEmpty() || needsToAdd) {
            System.out.println(0);
            return;
        }
        System.out.println(result);
    }
}