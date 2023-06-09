package algorithm.leet744;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (target < letters[i]) {
                return letters[i];
            }
        }
        return letters[letters.length - 1];
    }
}
