// https://school.programmers.co.kr/learn/courses/30/lessons/12906
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        ArrayList<Integer> result = new ArrayList<>();

        result.add(arr[0]);

        for (int i = 1; i < arr.length; i++){
            if(result.get(result.size()-1) != arr[i]){
                result.add(arr[i]);
            }
        }

        return result.stream().mapToInt(n->n).toArray();
    }
}
