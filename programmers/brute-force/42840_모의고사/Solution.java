// https://school.programmers.co.kr/learn/courses/30/lessons/42840
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] one = {1, 2, 3, 4, 5}; // 5
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i=0; i<answers.length; i++){
            // 1번 수포자 맞은 문제 세기
            if (answers[i] == one[i%5]){
                count1++;
            }
            if (answers[i] == two[i%8]){
                count2++;
            }
            if (answers[i] == three[i%10]){
                count3++;
            }
        }

        int max = Math.max(count1, Math.max(count2, count3));

        List<Integer> person = new ArrayList<>();

        if (count1 == max){
            person.add(1);
        }
        if (count2 == max){
            person.add(2);
        }
        if (count3 == max){
            person.add(3);
        }

        Collections.sort(person);

        return person.stream().mapToInt(n->n).toArray();
    }
}

/*
대안 풀이: 답안 패턴과 점수를 배열로 관리

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[patterns.length];
        int max = 0;

        for (int person = 0; person < patterns.length; person++) {
            int[] pattern = patterns[person];
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == pattern[i % pattern.length]) {
                    scores[person]++;
                }
            }
            max = Math.max(max, scores[person]);
        }

        List<Integer> winners = new ArrayList<>();
        for (int person = 0; person < scores.length; person++) {
            if (scores[person] == max) {
                winners.add(person + 1);
            }
        }
        return winners.stream().mapToInt(n -> n).toArray();
    }
}
*/
