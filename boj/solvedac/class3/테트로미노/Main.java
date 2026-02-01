//  테트로미노 (백준 14500번)

/*
* - 첫접근: 각 테트로미노의 좌표를 미리 지정하고 합 다 더하기
* - 다른 방법: dfs. 대신 ㅗ 예외처리 필요
* */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] map;
    static int[][][] tetromino = {
            // (y,x)
            // I
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

            // O
            {{0,0}, {1,0}, {0,1}, {1,1}},

            // L
            {{0,0}, {1, 0}, {2,0}, {2, 1}},
            {{0,0}, {1,0}, {0,1}, {0,2}},
            {{1,0}, {1,1}, {1,2}, {0,2}},
            {{0,0}, {0,1}, {1,1}, {2,1}},
            {{2,0},{2,1},{1,1},{0,1}},
            {{0,0}, {1,0},{1,1},{1,2}},
            {{0,0}, {0,1},{1,0},{2,0}},
            {{0,0},{0,1},{0,2},{1,2}},

            // S
            {{0,0}, {1,0}, {1,1}, {2,1}},
            {{1,0},{1,1},{0,1},{0,2}},
            {{0,1},{1,1},{1,0},{2,0}},
            {{0,0}, {0,1},{1,1},{1,2}},

            // ㅗ
            {{0,0}, {0,1}, {0,2}, {1,1}},
            {{1,0},{1,1},{1,2},{0,1}},
            {{0,0},{1,0},{2,0},{1,1}},
            {{0,1},{1,1},{2,1}, {1,0}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 19; k++) {
                    int sum = 0;
                    boolean correct = true;
                    for (int l = 0; l < 4; l++) {
                        int nx = j + tetromino[k][l][1];
                        int ny = i + tetromino[k][l][0];

                        if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                            correct = false;
                            break;
                        }
                        sum += map[ny][nx];
                    }
                    if (correct){
                        result = Math.max(result, sum);
                    }
                }
            }
        }
        System.out.println(result);
    }
}

/*
- dfs 코드 (이 방식이 좌표 실수 안할 수 있어서 효율적)
class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;

    // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                visited[y][x] = true;
                dfs(y, x, 1, map[y][x]);
                visited[y][x] = false;

                checkT(y, x); // ㅗ 예외
            }
        }

        System.out.println(answer);
    }

    // DFS (길이 4)
    static void dfs(int y, int x, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, depth + 1, sum + map[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    // ㅗ 모양 처리
    static void checkT(int y, int x) {
        // 4방향 중 3개 선택
        for (int i = 0; i < 4; i++) {
            int sum = map[y][x];
            boolean ok = true;

            for (int j = 0; j < 3; j++) {
                int dir = (i + j) % 4;
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    ok = false;
                    break;
                }
                sum += map[ny][nx];
            }

            if (ok) answer = Math.max(answer, sum);
        }
    }
}
* */