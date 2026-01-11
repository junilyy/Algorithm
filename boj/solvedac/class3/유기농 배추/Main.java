//  유기농 배추 (백준 1012번)

/*
배추가 있는 위치를 찾고 BFS로 덩어리를 파악 후 애벌레 수 세기
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            // 0으로 초기화
            for (int i = 0; i < N; i++) {
                Arrays.fill(map[i], 0);
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        bfs(i, j);
                        count += 1;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void bfs(int cy, int cx){
        Queue<int[]> q = new ArrayDeque<>();

        // queue에 현재 포지션 집어넣고 0으로 변경(이미 방문)
        q.add(new int[]{cx, cy});
        map[cy][cx] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            // 동서남북 파악
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 확인
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                // 덩어리에 포함 시키기
                if (map[ny][nx] == 1) {
                    map[ny][nx] = 0;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    };
}