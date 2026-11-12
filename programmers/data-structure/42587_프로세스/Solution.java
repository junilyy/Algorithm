// https://school.programmers.co.kr/learn/courses/30/lessons/42587
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();

        // 각 프로세스별 원래 priority 및 location 기록
        for (int i=0; i<priorities.length; i++){
            queue.offer(new int[]{priorities[i], i});
        }

        int count = 0; // 실행 횟수

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            // 우선순위가 더 높은 프로세스가 있는 경우 (조건 2)
            if (hasHigherPriority(queue, cur[0])){
                queue.offer(cur);
            }
            else{
                // 프로세스 실행 (조건 3)
                count +=1;

                // 실행한 프로세스가 location에 해당하는 경우 결과 반환
                if (cur[1] == location){
                    return count;
                }
            }
        }

        return 0;
    }

    boolean hasHigherPriority(Queue<int[]> queue, int curPriority){
        for(int[] process : queue){
            if (process[0] > curPriority){
                return true;
            }
        }

        return false;
    }
}

/*
우선순위별 남은 개수를 세는 대안 풀이

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] remaining = new int[10];
        int maxPriority = 0;

        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            queue.offer(new int[]{priority, i});
            remaining[priority]++;
            maxPriority = Math.max(maxPriority, priority);
        }

        int executed = 0;

        while (!queue.isEmpty()) {
            int[] process = queue.poll();
            int priority = process[0];

            if (priority < maxPriority) {
                queue.offer(process);
                continue;
            }

            executed++;
            remaining[priority]--;

            if (process[1] == location) {
                return executed;
            }

            while (maxPriority > 0 && remaining[maxPriority] == 0) {
                maxPriority--;
            }
        }

        return 0;
    }
}
*/
