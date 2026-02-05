//  스티커 (백준 9465번)

/*
* - 첫 접근: 동서남북이어서 bfs 생각
* - 문제: 최단 경로도 아니고 루트 찾는게 아니라서 적용 불가능
* - 해결: 힌트 받음, DP로 풀자. (각 행별로 위, 아래, 미선택 했을 때의 최댓값을 누적해가면 됨)
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // DP (0은 위, 1은 아래, 2는 아예 선택 안한 경우)
            int[][] dp = new int[3][n];

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[2][0] = 0;

            for (int i = 1; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + sticker[1][i];
                dp[2][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
            }
            System.out.println(Math.max(dp[0][n-1], Math.max(dp[1][n-1], dp[2][n-1])));
        }




    }
}