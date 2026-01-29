//  적록색약 (백준 10026번)

/*
* 첫 접근: bfs(direction)으로 구역 찾는 문제. 적록색약 O, 적록색약X의 visited를 분리해서 관리하면 될듯
* 복습:
* 다른 사람 코드 확인해보니 dfs로 구현
* colorBlind의 인자로 색을 넘겨줘서 그게 RG에 포함되면 조건문을 다르게 하여 bfs 실행, 다른 사람은 그냥 배열 자체롤 R 혹은 G로 통일
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static char[][] map;
    static boolean[][] blindVisited;
    static boolean[][] normalVisited;

    // direction
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        blindVisited = new boolean[N][N];
        normalVisited = new boolean[N][N];

        // 결과 출력용
        int blindResult = 0;
        int normalResult = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (blindVisited[i][j] == false) {
                    colorBlind(j, i, map[i][j]);
                    blindResult += 1;
                }
                if (normalVisited[i][j] == false) {
                    nonColorBlind(j, i, map[i][j]);
                    normalResult += 1;
                }
            }
        }
        System.out.println(normalResult + " " + blindResult);
    }

    static void colorBlind(int x, int y, char color){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N){
                    continue;
                }

                String rg = "RG";

                if (rg.contains(String.valueOf(color))) {
                    if (blindVisited[ny][nx] == false && (map[ny][nx] == 'R' || map[ny][nx] == 'G')){
                        queue.add(new int[]{nx, ny});
                        blindVisited[ny][nx] = true;
                    }
                }
                else {
                    if (blindVisited[ny][nx] == false && map[ny][nx] == color){
                        queue.add(new int[]{nx, ny});
                        blindVisited[ny][nx] = true;
                    }
                }

            }
        }
    }

    static void nonColorBlind(int x, int y, char color){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N){
                    continue;
                }

                if (normalVisited[ny][nx] == false && map[ny][nx] == color){
                    queue.add(new int[]{nx, ny});
                    normalVisited[ny][nx] = true;
                }
            }
        }
    }
}