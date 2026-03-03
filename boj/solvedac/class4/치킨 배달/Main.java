//  치킨 배달(15686번)

/*
* 첫 접근: 시간복잡도 때문에 어떻게 해야할지 의문이었음 -> 그냥 구현해보자.
* 문제: 치킨 거리를 잘못 이해. 치킨집을 기준으로 생각하는게 아니라 각 집을 기준으로 치킨거리 생각해야함.
* 문제 해결: 백트래킹으로 치킨집 조합 선정, M개의 치킨집이 선택됐을 경우 각 집에 대한 치킨 거리 최솟값 계산 -> 반복하면서 최솟값 갱신
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] dist;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static int homeIndex, chickenIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 최대 선택해야하는 치킨집 수

        // 집과 치킨집의 좌표 저장 배열 (row, col)
        int[][] home = new int[2 * N][2];
        int[][] chicken = new int[13][2];

        homeIndex = 0;
        chickenIndex = 0;

        // 집과 치킨집의 좌표 저장
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N+1; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1){
                    home[homeIndex][0] = i;
                    home[homeIndex][1] = j;
                    homeIndex++;
                }
                else if (num == 2){
                    chicken[chickenIndex][0] = i;
                    chicken[chickenIndex][1] = j;
                    chickenIndex++;
                }
            }
        }

        // 치킨 거리 계산 및 저장
        dist = new int[homeIndex][chickenIndex];

        for (int i = 0; i < homeIndex; i++) {
            for (int j = 0; j < chickenIndex; j++) {
                dist[i][j] = Math.abs(home[i][0] - chicken[j][0]) + Math.abs(home[i][1] - chicken[j][1]);
            }
        }

        visited = new boolean[chickenIndex];

        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int index, int cnt){
        if (cnt == M) {
            answer = Math.min(answer, calcChicken());
            return;
        }

        if (index == chickenIndex) {
            return;
        }
        visited[index] = true;
        dfs(index+1, cnt+1);

        visited[index] = false;
        dfs(index + 1, cnt);
    }

    static int calcChicken(){
        int sum = 0;
        for (int i = 0; i < homeIndex; i++){
            int best = Integer.MAX_VALUE;
            for (int j = 0; j < chickenIndex; j++){
                if (visited[j]){
                    best = Math.min(best, dist[i][j]);
                }
            }
            sum += best;
        }
        return sum;
    }
}