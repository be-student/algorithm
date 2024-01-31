package algorithm.kakao202401;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
                        "frodo ryan", "neo muzi"}));
    }

    public static int solution(String[] friends, String[] gifts) {
        //1. 모든 친구의 선물 지수를 구한다 Map<String,Int>
        Map<String, Integer> presentFactor = new HashMap<>();
        for (String friend : friends) {
            presentFactor.put(friend, 0);
        }
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String sender = split[0];
            String receiver = split[1];
            presentFactor.put(sender, presentFactor.get(sender) + 1);
            presentFactor.put(receiver, presentFactor.get(receiver) - 1);
        }

        //2. Map<String, Map<String,Int>> 형태로 보낸 선물의 수를 세어준다
        Map<String, Map<String, Integer>> sendPresentToReceiverToCount = new HashMap<>();
        for (String friend : friends) {
            sendPresentToReceiverToCount.put(friend, new HashMap<>());
        }
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String sender = split[0];
            String receiver = split[1];
            int sentCount = sendPresentToReceiverToCount.get(sender)
                    .getOrDefault(receiver, 0);
            sendPresentToReceiverToCount.get(sender)
                    .put(receiver, sentCount + 1);
        }

        //3. 모든 친구를 돌면서, 모든 친구와 다 계산했을 때, 나온 최대값을 반환한다
        int answer = 0;
        for (String sender : friends) {
            int particularAnswer = 0;
            for (String receiver : friends) {
                if (sender.equals(receiver)) {
                    continue;
                }
                Map<String, Integer> senderMap = sendPresentToReceiverToCount.get(sender);
                int senderCount = senderMap.getOrDefault(receiver, 0);
                Map<String, Integer> receiverMap = sendPresentToReceiverToCount.get(receiver);
                int receiverCount = receiverMap.getOrDefault(sender, 0);
                if (senderCount != receiverCount) {
                    //두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
                    if (senderCount > receiverCount) {
                        particularAnswer++;
                    }
                } else {
                    //두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                    int senderFactor = presentFactor.get(sender);
                    int receiverFactor = presentFactor.get(receiver);
                    if (senderFactor > receiverFactor) {
                        particularAnswer++;
                    }
                }
                answer = Math.max(answer, particularAnswer);
            }
        }
        return answer;
    }
}
