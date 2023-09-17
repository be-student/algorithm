package algorithm.boj2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        String string = br.readLine();
        List<List<Integer>> allPossibleBracketIndex = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '(') {
                deque.push(i);
            } else if (c == ')') {
                List<Integer> list = new ArrayList<>();
                list.add(deque.pop());
                list.add(i);
                allPossibleBracketIndex.add(list);
            }
        }

        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 1; i <= allPossibleBracketIndex.size(); i++) {
            List<List<Integer>> getAllPermutation = getAllPermutation(allPossibleBracketIndex);
            for (List<Integer> list : getAllPermutation) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < string.length(); j++) {
                    if (list.contains(j)) {
                        continue;
                    }
                    sb.append(string.charAt(j));
                }
                treeSet.add(sb.toString());
            }
        }
        for (String s : treeSet) {
            sb.append(s)
                    .append("\n");
        }
    }

    private List<List<Integer>> getAllPermutation(List<List<Integer>> allPossibleBracketIndex) {
        List<List<Integer>> result = new ArrayList<>();
        if (allPossibleBracketIndex.size() == 1) {
            result.add(allPossibleBracketIndex.get(0));
            return result;
        }
        for (int i = 0; i < allPossibleBracketIndex.size(); i++) {
            List<Integer> list = allPossibleBracketIndex.get(i);
            List<List<Integer>> allPermutation = getAllPermutation(
                    getAllPossibleBracketIndexExcept(allPossibleBracketIndex, i));
            for (List<Integer> integers : allPermutation) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.addAll(integers);
                result.add(newList);
            }
        }
        return result;
    }

    private List<List<Integer>> getAllPossibleBracketIndexExcept(List<List<Integer>> allPossibleBracketIndex, int i) {
        List<List<Integer>> result = new ArrayList<>();
        for (int j = 0; j < allPossibleBracketIndex.size(); j++) {
            if (i == j) {
                continue;
            }
            result.add(allPossibleBracketIndex.get(j));
        }
        return result;
    }
}
