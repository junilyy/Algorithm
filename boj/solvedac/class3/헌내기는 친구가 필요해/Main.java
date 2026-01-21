//  헌내기는 친구가 필요해 (백준 21736번)

/*
첫 접근: bfs 문제다 -> 맞음
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        int sy = -1, sx = -1; // 시작 지점

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    sy = i;
                    sx = j;
                }
            }
        }

        int result = bfs(sy, sx);
        if (result == 0) {
            System.out.println("TT");
        }
        else{
            System.out.println(result);
        }
    }

    static int bfs(int sy, int sx){
        int count = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy});
        visited[sy][sx] = true;

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];

            if (map[y][x] == 'P'){
                count+=1;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx] ) {
                    continue;
                }

                if (map[ny][nx] == 'X') {
                    continue;
                }

                queue.add(new int[] {nx, ny});
                visited[ny][nx] = true;

            }
        }

        return count;
    }
}