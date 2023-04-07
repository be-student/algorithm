package algorithm.leet2405;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int partitionString(String s) {
        int ans = 0;
        Set<Character> characters = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (characters.contains(c)) {
                ans++;
                characters.clear();
            }
            characters.add(c);
        }
        if (!characters.isEmpty()) {
            ans++;
        }
        return ans;
    }
}
