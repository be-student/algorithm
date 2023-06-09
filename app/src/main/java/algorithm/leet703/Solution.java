package algorithm.leet703;

import java.util.ArrayList;
import java.util.List;

class KthLargest {

    private final int k;
    List<Integer> integers = new ArrayList<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (var num : nums) {
            integers.add(num);
        }
    }

    public int add(int val) {
        integers.add(val);
        integers.sort(Integer::compareTo);
        return integers.get(integers.size() - k);
    }
}
