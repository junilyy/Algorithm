//  평범한 배낭

/*
* 첫 접근: 백트래킹을 써서 탈출 조건은 배낭에 담을 수 있는 K로 판단 or 정렬
* 문제: 백트래킹은 시간 초과 발생, 정렬은 구하는 방법이 안떠오름
* 해결: 아이디어 참고 -> DP
* */
import java.nio.Buffer;
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // dp[w]: 무게 w까지 쓸 수 있을 때의 최대 가치
        int[] dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            // dp 갱신(현재 무게에서의 가치와 입력의 weight의 value를 고려했을 때의 값 중 최댓값)
            for (int j = K; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }
        }
        System.out.println(dp[K]);

    }
}

/*
- 백트래킹
class Main {
    static int max = Integer.MIN_VALUE;
    static int[][] stuff;
    static boolean[] visited;
    static int N, K;
    static int weight = 0;
    static int value = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stuff = new int[N][2];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }
        bagTrack(0, 0);
        System.out.println(max);
    }
    static void bagTrack(int index, int v){
        if (weight > K){
            max = Math.max(max, value - v);
            return;
        }

        for (int i = index; i < N; i++) {
            if (visited[i] == true) continue;
            visited[i] = true;
            weight += stuff[i][0];
            value += stuff[i][1];
            bagTrack(i+1, stuff[i][1]);
            visited[i] = false;
            weight -= stuff[i][0];
            value -= stuff[i][1];
        }
    }
}
*/