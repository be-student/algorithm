package algorithm.leet443;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(new Solution().compress(chars));
    }

    public int compress(char[] chars) {
        char before = chars[0];
        int count = 1;
        List<Character> characters = new ArrayList<>();
        for (int i = 1; i < chars.length; i++) {
            if (before == chars[i]) {
                count++;
            } else {
                add(characters, before, count);
                count = 1;
                before = chars[i];
            }

        }
        add(characters, before, count);
        int[] result = characters.stream().mapToInt(Character::charValue).toArray();
        for (int i = 0; i < result.length; i++) {
            chars[i] = (char) result[i];
        }
        return result.length;
    }

    private void add(List<Character> characters, char character, int count) {
        characters.add(character);
        if (count != 1) {
            char[] chars = Integer.toString(count).toCharArray();
            for (char aChar : chars) {
                characters.add(aChar);
            }
        }
    }
}
