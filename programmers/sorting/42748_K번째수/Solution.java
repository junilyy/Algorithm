// https://school.programmers.co.kr/learn/courses/30/lessons/42748
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int t=0; t<commands.length; t++){
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];

            // copyOfRange(원본배열, 시작인덱스, 끝인덱스)-시작인덱스는 포함하고 끝 인덱스는 포함하지 않음.
            int[] sliced = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(sliced);
            answer[t] = sliced[k-1];
        }

        return answer;
    }
}
