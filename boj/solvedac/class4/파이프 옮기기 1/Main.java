//  파이프 옮기기 1(백준 17070번)

/*
* 첫 접근: direction 이용하는 bfs인가??
* 문제: 그렇기엔 최단거리 이용하는 것도 아니고 가로,세로,대각선의 케이스가 다름
* 문제해결: 완전탐색(dfs) - 가로: 0, 세로: 1, 대각선: 2
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int map[][];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(count);
    }

    static void dfs(int r, int c, int direction) {
        if (r == N-1 && c == N-1){
            count++;
            return;
        }

        switch(direction) {
            case 0:
                //가로
                if (c+1 < N && map[r][c+1] == 0){
                    dfs(r, c+1, 0);
                }
                //대각
                if (r+1 < N && c+1 < N
                    && map[r][c+1] == 0
                    && map[r+1][c] == 0
                    && map[r+1][c+1] == 0){
                    dfs(r+1, c+1, 2);
                }
                break;
            case 1:
                // 세로
                if (r+1 < N && map[r+1][c] == 0){
                    dfs(r+1, c, 1);
                }
                //대각
                if (r+1 < N && c+1 < N
                        && map[r][c+1] == 0
                        && map[r+1][c] == 0
                        && map[r+1][c+1] == 0){
                    dfs(r+1, c+1, 2);
                }
                break;
            case 2:
                //가로
                if (c+1 < N && map[r][c+1] == 0){
                    dfs(r, c+1, 0);
                }
                // 세로
                if (r+1 < N && map[r+1][c] == 0){
                    dfs(r+1, c, 1);
                }
                //대각
                if (r+1 < N && c+1 < N
                        && map[r][c+1] == 0
                        && map[r+1][c] == 0
                        && map[r+1][c+1] == 0){
                    dfs(r+1, c+1, 2);
                }
                break;
        }
    }
}