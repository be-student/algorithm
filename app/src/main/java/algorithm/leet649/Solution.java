package algorithm.leet649;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String predictPartyVictory(String senate) {
        while (true) {
            List<Integer> rIndex = new ArrayList<>();
            List<Integer> dIndex = new ArrayList<>();

            for (int i = 0; i < senate.length(); i++) {
                if (senate.charAt(i) == 'R') {
                    rIndex.add(i);
                } else {
                    dIndex.add(i);
                }
            }

            while (!rIndex.isEmpty() && !dIndex.isEmpty()) {
                if (rIndex.get(0) < dIndex.get(0)) {
                    rIndex.add(rIndex.get(0) + senate.length());
                } else {
                    dIndex.add(dIndex.get(0) + senate.length());
                }
                rIndex.remove(0);
                dIndex.remove(0);
            }
            if (rIndex.isEmpty()) {
                return "Dire";
            }
            if (dIndex.isEmpty()) {
                return "Radiant";
            }
        }
    }
}
