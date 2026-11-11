// https://school.programmers.co.kr/learn/courses/30/lessons/42586
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];

        for (int i=0; i<progresses.length; i++){
            days[i] = (int) Math.ceil((double) (100-progresses[i])/speeds[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();

        int deployDay = 0; // 배포일 기준점
        int count = 0; // 배포일에 해당하는 기능 배포 수

        for (int i=0; i<days.length; i++){
            if (i == 0) {
                deployDay = days[0];
                count += 1;
                continue;
            }

            if (deployDay >= days[i]){
                count += 1;
            }
            else {
                result.add(count);
                deployDay = days[i];
                count = 1;
            }
        }

        if (count > 0){
            result.add(count);
        }

        return result.stream().mapToInt(n->n).toArray();
    }
}

/*
GPT 피셜 모범답안

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> batches = new ArrayList<>();
        int deployDay = 0;
        int count = 0;

        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];
            int speed = speeds[i];
            int days = (remaining + speed - 1) / speed;

            if (days > deployDay) {
                if (count > 0) {
                    batches.add(count);
                }
                deployDay = days;
                count = 0;
            }

            count++;
        }

        if (count > 0) {
            batches.add(count);
        }

        return batches.stream().mapToInt(n -> n).toArray();
    }
}
*/
