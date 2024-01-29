package algorithm.leet2310;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(minimumNumbers(2, 8));
    }

    public static int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i <= Math.max(num * 3, 30); i++) {
            integers.add(-1);
        }
        integers.set(0, 0);
        for (int i = 0; i <= num; i += 10) {
            for (int j = 0; j <= num; j++) {
                if (integers.get(j) >= 0) {
                    if (integers.get(j + i + k) < 0) {
                        integers.set(j + i + k, integers.get(j) + 1);
                    } else {
                        integers.set(j + i + k, Math.min(integers.get(j) + 1, integers.get(j + i + k)));
                    }
                }
            }
        }
        return integers.get(num);
    }
}
