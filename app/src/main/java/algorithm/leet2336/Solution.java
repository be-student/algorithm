package algorithm.leet2336;

import java.util.TreeSet;

class SmallestInfiniteSet {

    private final TreeSet<Integer> treeSet = new TreeSet<>();

    public SmallestInfiniteSet() {
        for (int i = 0; i < 10000; i++) {
            treeSet.add(i);
        }
    }

    public int popSmallest() {
        if (!treeSet.isEmpty()) {
            return treeSet.pollFirst();
        } else {
            return -1;
        }
    }

    public void addBack(int num) {
        treeSet.add(num);
    }
}
