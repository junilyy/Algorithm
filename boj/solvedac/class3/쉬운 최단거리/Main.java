//  쉬운 최단거리(백준 14940번)

/*
* - 첫 접근: bfs 문제인데 경로의 단계를 표시하면 됨. 이전 visited로부터 1 추가해서 넣으면 끝
* - 갈 수 있는 땅인데 도달 못하는 경우(-1)와 원래 갈 수 없는 땅인 경우(0) 구분은 visited 배열 선언 후 map 입력값 받을 때 변경
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map; // input
    static int[][] visited;
    static int N, M;

    // direction
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // visited 배열 선언 및 초기화
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        // 시작 지점의 x, y 좌표
        int sx = 0;
        int sy = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    sx = j;
                    sy = i;
                }

                if (map[i][j] == 0) {
                    visited[i][j] = 0;
                }
            }
        }



        // bfs
        bfs(sx, sy);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(visited[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
    }
    static void bfs(int sx, int sy) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy});
        visited[sy][sx] += 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N){
                    continue;
                }

                if (map[ny][nx] == 1 && visited[ny][nx] == -1) {
                    visited[ny][nx] = visited[cy][cx] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

    }
}