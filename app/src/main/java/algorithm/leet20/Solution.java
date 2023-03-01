package algorithm.leet20;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                deque.addLast(bracket);
                continue;
            }
            if (deque.isEmpty()) {
                return false;
            }
            if (bracket == ')') {
                char last = deque.pollLast();
                if (last != '(') {
                    return false;
                }
            }
            if (bracket == '}') {
                char last = deque.pollLast();
                if (last != '{') {
                    return false;
                }
            }
            if (bracket == ']') {
                char last = deque.pollLast();
                if (last != '[') {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}