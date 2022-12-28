package algorithm.leet914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    public boolean hasGroupsSizeX(int[] deck) {
        List<Integer> temp = new ArrayList<>(Arrays.stream(deck)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)))
                .values());
        int result = temp.get(0);
        for (int value : temp) {
            result = gcd(result, value);
        }
        if (result != 1) {
            return true;
        }
        return false;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}