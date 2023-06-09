package algorithm.leet399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    Map<String, String> parent = new HashMap<>();
    Map<String, Double> val = new HashMap<>();
    Set<String> visited = new HashSet<>();

    private void union(String a, String b) {
        a = findParent(a);
        b = findParent(b);

        parent.put(b, a);
    }

    private String findParent(String b) {
        if (parent.get(b).equals(b)) {
            return b;
        }
        String bParent = findParent(parent.get(b));
        parent.put(b, bParent);
        return bParent;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (List<String> equation : equations) {
            parent.put(equation.get(0), equation.get(0));
            parent.put(equation.get(1), equation.get(1));
        }
        for (List<String> equation : equations) {
            union(equation.get(0), equation.get(1));

        }

        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);

            String fParent = findParent(first);
            String sParent = findParent(second);

        }

        double[] result = new double[equations.size()];

        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);

            if (!findParent(first).equals(findParent(second))) {
                result[i] = -1;
            }

            result[i] = val.get(first) / val.get(second);
        }

        return result;
    }
}
