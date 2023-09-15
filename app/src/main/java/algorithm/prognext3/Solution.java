package algorithm.prognext3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(
                new String[]{"토스커피사일로 베이커리", "토스커피사일", "토스커피사일로 베이커", "토스커피사일로 베이", "토스커피사일로&베이커리"})));
    }

    public String[] solution(String[] merchantNames) {
        List<String> names = new ArrayList<>();
        for (String merchantName : merchantNames) {
            names.add(merchantName);
        }
        List<String> answer = new ArrayList<>();
        while (!names.isEmpty()) {
            int maxNameLengthIndex = 0;
            for (int i = 0; i < names.size(); i++) {
                int firstLength = calculateNameLength(names.get(i));
                String name = names.get(maxNameLengthIndex);
                int i1 = calculateNameLength(name);
                if (firstLength > i1) {
                    if (calculateSpecialCharacterCount(names.get(i)) >= calculateSpecialCharacterCount(
                            name)) {
                        maxNameLengthIndex = i;
                    }
                }
            }
            String maxName = names.get(maxNameLengthIndex);
            answer.add(maxName);
            names.remove(maxName);
            removeContains(names, maxName);

        }

        return answer.toArray(String[]::new);
    }

    private void removeContains(List<String> names, String s) {
        for (int i = 0; i < names.size(); i++) {
            String now = names.get(i);
            if (hasString(s, now)) {
                names.remove(i);
                i--;
            }
            ;
        }
    }

    private boolean hasString(String s, String now) {
        int nowIndex = 0;
        String newNow = removeNowSpecial(now);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == newNow.charAt(nowIndex)) {
                nowIndex++;
            }
            if (nowIndex == newNow.length()) {
                return true;
            }
        }
        return false;
    }

    private String removeNowSpecial(String now) {
        List<Character> specialCharacters = List.of('&', '(', ')', '.', ',', '-', ' ');
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < now.length(); i++) {
            if (specialCharacters.contains(now.charAt(i))) {
                continue;
            }
            stringBuilder.append(now.charAt(i));
        }
        return stringBuilder.toString();
    }


    private int calculateNameLength(String name) {
        int length = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                continue;
            }
            length++;
        }
        return length;
    }

    private int calculateSpecialCharacterCount(String name) {
        List<Character> specialCharacters = List.of('&', '(', ')', '.', ',', '-');
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            if (specialCharacters.contains(name.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
