//  토마토_2 (백준 7569번)

/*
* 첫 접근: 토마토의 업그레이드 버전 2차원 -> 3차원. but 원리는 똑같이
* -> but 이전 코드랑 다르게 start 위치를 저장하는 배열을 굳이 따로 만들지 말고 바로 Queue에 집어넣기
* -> 익지 않은 토마토의 존재 여부를 어떻게 효율적으로 판단할까.. -> 이거 다른 사람 코드 보니 그냥 배열 전체 순회하는듯(구현 난이도 낮음)
* */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // M, N, H
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // 토마토 map 선언(3차원 배열)
        int[][][] map = new int[H][N][M];

        // bfs용 큐 (익은 토마토의 위치를 미리 집어넣기 위함)
        Queue<int[]> queue = new ArrayDeque<>();

        // bfs의 방문 확인용 + 초기화
        int[][][] visited = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }

        // 전체 토마토의 수
        int allTomato = 0;
        int goodTomato = 0;

        // 토마토 map 저장 및 bfs 시작 위치 저장
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.add(new int[]{k, j, i});
                        visited[i][j][k] = 0;
                        goodTomato += 1;
                        allTomato += 1;
                    }
                    else if (map[i][j][k] == 0){
                        allTomato += 1;
                    }
                }
            }
        }

        //direction
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        /// 결과 출력용
        // 애초에 전부 익은 토마토일 수 있으니 0일부터 시작.
        int result = 0;

        // bfs
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];

            for (int i = 0; i < 6; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) {
                    continue;
                }

                if (visited[nz][ny][nx] == -1 && map[nz][ny][nx] == 0) {
                    queue.add(new int[]{nx, ny, nz});
                    visited[nz][ny][nx] = visited[cz][cy][cx] + 1;
                    goodTomato += 1;

                    if (visited[nz][ny][nx] > result){
                        result = visited[nz][ny][nx];
                    }
                }
            }
        }
        // 전체 토마토 수보다 익은 토마토의 수가 작은 경우
        if (goodTomato < allTomato){
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }



    }
}