package algorithm.leet145;

class Solution {

    public boolean isPalindrome(String s) {
        String removeSpace = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        for (int i = 0; i < removeSpace.length(); i++) {
            if (i > removeSpace.length() - i) {
                return true;
            }
            System.out.println(i);
            System.out.println(removeSpace.charAt(i));
            System.out.println(removeSpace.charAt(removeSpace.length() - i - 1));
            if (removeSpace.charAt(i) != removeSpace.charAt(removeSpace.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}