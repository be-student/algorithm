package algorithm.leet242;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char temp : s.toCharArray()) {
            count.put(temp, count.getOrDefault(temp, 0) + 1);
        }
        for (char temp : t.toCharArray()) {
            int oneCount = count.getOrDefault(temp, 0) - 1;
            if (oneCount < 0) {
                return false;
            }
            count.put(temp, oneCount);
        }
        return true;
    }
}