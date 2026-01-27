//  토마토 (백준 7576번)

/*
* 첫 접근: bfs 이용하되 direction을 이용하면 될 것 같음, visited는 일수로 설정
* -> 근데 익은 토마토(첫 시작지점)이 여러개일 수 있네.. -> 시작 지점을 queue에 다 넣어놓고 전파시키자.
* */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] map;
    static int[][] visited;
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        List<int[]> start = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    start.add(new int[]{j, i}); // 익은 토마토의 x, y
                }
            }
        }

        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        bfs(start);

        boolean badTomato = false;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, visited[i][j]);
                if (map[i][j] != -1 && visited[i][j] == -1) {
                    badTomato = true;
                }
            }
        }

        if (badTomato){ // 토마토가 다 익지 않은 경우
            System.out.println("-1");
        }
        else {
            System.out.println(max);
        }

    }

    static void bfs(List<int[]> start){
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < start.size(); i++){
            int x = start.get(i)[0];
            int y = start.get(i)[1];
            queue.add(new int[]{x, y});
            visited[y][x] = 0;
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (visited[ny][nx] == -1 && map[ny][nx] == 0){
                    queue.add(new int[]{nx, ny});
                    visited[ny][nx] = visited[cy][cx] + 1;
                }

            }
        }
    }
}