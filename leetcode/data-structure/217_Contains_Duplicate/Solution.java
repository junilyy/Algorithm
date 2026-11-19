// https://leetcode.com/problems/contains-duplicate/
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            if (map.containsKey(num)){
                return true;
            }
            map.put(num, 0);
        }

        return false;
    }
}

/*
HashSet 버전: 등장한 숫자를 저장

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}

add()는 이미 있는 값이면 false를 반환하므로 반복문을 다음처럼 작성할 수도 있음.

for (int num : nums) {
    if (!seen.add(num)) {
        return true;
    }
}
*/
