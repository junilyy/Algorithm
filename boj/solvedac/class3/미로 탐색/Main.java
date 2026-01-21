//  미로 탐색(2178번)

/*
* - 첫 접근: BFS로 찾되, 최소 경로니 남,동 방향을 for문에서 우선적으로 탐색하게 (바로 성공)
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 미로 map
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        // direction 설정
        int[] dx = {0, 1, -1, 0};
        int[] dy = {-1, 0, 0, 1};

        // visisted 배열 초기화(count 담당)
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = 0;
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || map[ny][nx] == 0) {
                    continue;
                }

                if (visited[ny][nx] == 0) {
                    queue.add(new int[]{nx, ny});
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }

        System.out.println(visited[N-1][M-1]);


    }
}