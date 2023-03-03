package algorithm.leet28;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sadbutsad", "sad"));
    }

    public int strStr(String haystack, String needle) {
        char[] first = haystack.toCharArray();
        char[] second = needle.toCharArray();

        for (int i = 0; i <= first.length - second.length; i++) {
            boolean isSame = true;
            for (int j = 0; j < second.length; j++) {
                if (first[i + j] != second[j]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return i;
            }
        }
        return -1;
    }
}
