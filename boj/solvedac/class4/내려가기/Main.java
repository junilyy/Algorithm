//  내려가기 (백준 2096번)

/*
* 첫 접근: 1,2,3번째 줄을 선택하는 경우로 나눠서 누적합 때리면 되지 않을까?
* 문제: int[][] sum 배열로 만들어서 계산하려니 힘듬..
* 해결: 아이디어 참고, 각 row에 대해서 0, 1, 2 위치에 대한 min, max만 기억하면 됨
* 주의: Dp 배열값이 실시간으로 변경되서 원하는 결과가 안나옴, 따라서 maxN, minN 변수를 이용해서 값 저장 후 이용
* */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // max값 계산
            int max0 = Math.max(maxDp[0], maxDp[1]) + a;
            int max1 = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + b;
            int max2 = Math.max(maxDp[1], maxDp[2]) + c;

            maxDp[0] = max0;
            maxDp[1] = max1;
            maxDp[2] = max2;

            // min값 계산
            int min0 = Math.min(minDp[0], minDp[1]) + a;
            int min1 = Math.min(minDp[0], Math.min(minDp[1], minDp[2])) + b;
            int min2 = Math.min(minDp[1], minDp[2]) + c;

            minDp[0] = min0;
            minDp[1] = min1;
            minDp[2] = min2;
        }
        int max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        int min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));
        System.out.println(max + " " + min);
    }
}

/*
class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[][] map = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[N][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                if (i - 1 >= 0){
                    sum[j][i-1] += (map[j][i-1] + map[j-1][i-1]);
                }
                sum[j][i] += map[j][i];
                if (i + 1 < 3){
                    sum[j][i+1] += map[j][i+1];
                }
            }
        }

    }
}
 */