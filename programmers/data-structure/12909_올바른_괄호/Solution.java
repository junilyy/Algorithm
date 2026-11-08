// https://school.programmers.co.kr/learn/courses/30/lessons/12909
import java.util.*;

/*
시간복잡도 O(n)
추가 공간 최악 O(n)
*/
class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }
            else{
                // case1: 열리지도 않았는데 닫힘
                if (stack.size() == 0){
                    // stack.isEmpty()를 쓰면 의도가 더 잘 보임
                    return false;
                }

                stack.pop();
            }
        }

        // case2: 안닫힘
        if (stack.size() > 0){
            return false;
        }

        return true;

        /* 위 if문과 return을 한 줄로 줄일 수 있음
            return stack.isEmpty();
        */
    }
}

/* 개수만 세는 대안 풀이
시간복잡도 O(n)
추가 공간 O(1)

class Solution {
    boolean solution(String s) {
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open == 0) {
                    return false;
                }
                open--;
            }
        }

        return open == 0;
    }
}
*/
