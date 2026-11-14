// https://school.programmers.co.kr/learn/courses/30/lessons/86491
class Solution {
    public int solution(int[][] sizes) {
        /*
        회전 때문에 가로, 세로의 구분이 무의미한듯.
        세로>가로인 경우의 세로 길이를 가로 길이로 취급해서 가로 최댓값 계산.
        -> 가로를 세로 길이로 취급해서 세로 길이 중에서 최댓값 찾아서 세로 최댓값 계산.
        */

        int cards = sizes.length;

        int maxWidth = 0;
        int maxHeight = 0;

        for (int i=0; i<cards; i++){
            int width = sizes[i][0];
            int height = sizes[i][1];

            if (height > width){
                maxWidth = Math.max(maxWidth, height);
                maxHeight = Math.max(maxHeight, width);
            }
            else{
                maxWidth = Math.max(maxWidth, width);
                maxHeight = Math.max(maxHeight, height);
            }

        }

        return maxWidth*maxHeight;
    }
}

/*
대안 풀이: 각 명함의 긴 변과 짧은 변을 구해 각각 최댓값을 기록

class Solution {
    public int solution(int[][] sizes) {
        int maxLongSide = 0;
        int maxShortSide = 0;

        for (int[] card : sizes) {
            int longSide = Math.max(card[0], card[1]);
            int shortSide = Math.min(card[0], card[1]);

            maxLongSide = Math.max(maxLongSide, longSide);
            maxShortSide = Math.max(maxShortSide, shortSide);
        }

        return maxLongSide * maxShortSide;
    }
}
*/
