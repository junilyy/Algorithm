// https://school.programmers.co.kr/learn/courses/30/lessons/12982
import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int count = 0;
        for (int cost: d){
            if (budget - cost >= 0){
                count++;
                budget -= cost;
            }
            else{
                break;
            }
        }

        return count;
    }
}

/*
대안 풀이: 누적 지원액이 예산을 처음 초과하면 그 앞까지의 부서 수를 반환

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int totalCost = 0;

        for (int i = 0; i < d.length; i++) {
            totalCost += d[i];
            if (totalCost > budget) {
                return i;
            }
        }

        return d.length;
    }
}
*/
