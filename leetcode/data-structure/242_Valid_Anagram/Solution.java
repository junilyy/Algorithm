// https://leetcode.com/problems/valid-anagram/
import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        // 두 string의 길이가 다른 경우 바로 false return
        if (s.length() != t.length()){
            return false;
        }

        for (int i=0; i<s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }

        for (char key: sMap.keySet()){
            int sCount = sMap.getOrDefault(key,0);
            int tCount = tMap.getOrDefault(key,0);

            if (sCount != tCount){
                return false;
            }
        }

        return true;
    }
}

/*
대안 풀이: 입력이 영문 소문자이므로 int[26]에 문자별 개수 차이를 기록

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
*/
