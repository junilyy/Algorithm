// https://school.programmers.co.kr/learn/courses/30/lessons/42576
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> counts = new HashMap<>();

        for (int i=0; i<participant.length; i++){
            counts.put(participant[i], counts.getOrDefault(participant[i],0)+1);
        }

        for (int i=0; i<completion.length; i++){
            counts.put(completion[i], counts.getOrDefault(completion[i],0)-1);
        }
        /* 위 for문 대체 가능한 버전
        for (String name : completion) {
            counts.put(name, counts.get(name) - 1);
        }
        */

        for (int i=0; i<participant.length; i++){
            if (counts.get(participant[i]) > 0){
                answer = participant[i];
            }
        }
        return answer;

        /* 위 for, return 대체 가능 버전
        for (String name : participant) {
            if (counts.get(name) > 0) {
                return name;
            }
        }
        return "";
        */
    }
}
