package algorithm.kakao202205;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},
                new int[]{5, 3, 2, 7, 5}));
    }

    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("R", 0);
        scores.put("T", 0);
        scores.put("C", 0);
        scores.put("F", 0);
        scores.put("J", 0);
        scores.put("M", 0);
        scores.put("A", 0);
        scores.put("N", 0);
        for (int i = 0; i < survey.length; i++) {
            String oneSurvey = survey[i];

            char a = oneSurvey.charAt(0);
            char b = oneSurvey.charAt(1);

            int score = choices[i];
            switch (score) {
                case 1:
                    scores.put(String.valueOf(a), scores.get(String.valueOf(a)) + 3);
                    break;
                case 2:
                    scores.put(String.valueOf(a), scores.get(String.valueOf(a)) + 2);
                    break;
                case 3:
                    scores.put(String.valueOf(a), scores.get(String.valueOf(a)) + 1);
                    break;
                case 5:
                    scores.put(String.valueOf(b), scores.get(String.valueOf(b)) + 1);
                    break;
                case 6:
                    scores.put(String.valueOf(b), scores.get(String.valueOf(b)) + 2);
                    break;
                case 7:
                    scores.put(String.valueOf(b), scores.get(String.valueOf(b)) + 3);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (scores.get("R") >= scores.get("T")) {
            sb.append("R");
        } else {
            sb.append("T");
        }
        if (scores.get("C") >= scores.get("F")) {
            sb.append("C");
        } else {
            sb.append("F");
        }
        if (scores.get("J") >= scores.get("M")) {
            sb.append("J");
        } else {
            sb.append("M");
        }
        if (scores.get("A") >= scores.get("N")) {
            sb.append("A");
        } else {
            sb.append("N");
        }
        return sb.toString();
    }
}
