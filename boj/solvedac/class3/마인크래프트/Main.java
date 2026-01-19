//  마인크래프트 (백준 18111번)

/*
* - 첫 접근: 높이의 평균을 이용한 단순 구현
* - 첫 접근 실패 이유: 높이의 평균과 높이의 평균 -1만 고려
* - 해결: 전체 높이 고려(0~256) -> 효율적으로 구현할 수 있을거 같긴 함(복습 때 고려)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] map;
    static int N,M,B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        double sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        int take = 0;
        int put = 0;
        int minTime = Integer.MAX_VALUE;
        int height = 0;

        for (int i = 256; i >= 0; i--) { // 시간이 같을 경우 땅의 높이가 가장 높은 것을 출력해야함
            int[] result = event(i);
            if (B >= (result[2] - result[1])){ // 가지고 있는 블록보다 더 많은 블록을 써야하는 경우 제외
                if (minTime > result[0]){
                    minTime = result[0];
                    height = i;
                }
            }
        }
        System.out.println(minTime + " " + height);
    }

    static int[] event(int height){

        int[] values = new int[3]; // time, take, put
        int time = 0;
        int take = 0;
        int put = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int diff = map[i][j] - height;
                if (diff > 0){
                    take += diff;
                }
                else {
                    put += -diff;
                }
            }
        }

        time = take * 2 + put;

        values[0] = time;
        values[1] = take;
        values[2] = put;

        return values;
    }
}